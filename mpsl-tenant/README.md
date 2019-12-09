# Mybatis-Plus 多租户SQL解析器

[**mpsl-tenant**](https://gitee.com/streamslience_1/mybatis-plus-simple-learn/tree/feature-1.0.0/StreamSlience/mpsl-tenant)

## 1.配置SQL解析器

`MybatisPlusConfig.java`

```java
package com.streamslience.simples.tenant.mpsltenant.configure;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.google.common.collect.Lists;
import com.streamslience.simples.tenant.mpsltenant.ApiContext;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StreamSlience
 * @descriptionc MybatisPlus 配置类
 * @creatdate 2019-12-09 13:27
 */
@Configuration
@MapperScan("com.streamslience.simples.tenant.mpsltenant.dao")
public class MybatisPlusConfig {

    @Autowired
    private ApiContext apiContext;

    //租户字段名
    private static final String SYSTEM_TENANT_COL = "tenant_id";
    //表过滤集合(有些表不需要租户字段)
    private static final List<String> IGNORE_TENANT_TABLES =
            Lists.newArrayList("tenant_info");

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /*
            测试多租户 SQL 解析处理拦截器
            实际情况可以从cookie里读取，因此数据看不到
            或是将租户ID存放在系统上下文中
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();

        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean where) {
                //该where条件 3.2.0 版本开始添加，用于区分是否为在where条件中使用
                //此判断用于支持返回多个租户ID场景，具体使用查看实例工程
                String tenantId = apiContext.getCurrentTenant();
                if (null == tenantId) {
                    throw new RuntimeException("get current tenant'id failed");
                }
                return new StringValue(tenantId);
            }

            @Override
            public String getTenantIdColumn() {
                return SYSTEM_TENANT_COL;
            }

            @Override
            public boolean doTableFilter(String tableName) {
                return IGNORE_TENANT_TABLES.stream().anyMatch(v -> v.equals(tableName));
            }
        });

        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
            @Override
            public boolean doFilter(MetaObject metaObject) {
                if ("com.streamslience.simples.tenant.mpsltenant.dao".equals(ms.getId())) {
                    return true;
                }
                return false;
            }
        });
        return paginationInterceptor;
    }

}
```

> 相关SQL解析如多租户可通过`@SqlParser(filter=true)`排除SQL解析，注意！！全局配置sqlParserCache设置为true才生效。(3.1.1开始不再需要这一步)
>
> ```yml
> #开启SQL解析缓存注解生效
> myabtis-plus:
> 	global-config:
> 		sql-parser-cache: true
> ```

将租户主键放在上下文中

`ApiContext.java`

```java
package com.streamslience.simples.tenant.mpsltenant;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 14:09
 */
@Component
public class ApiContext {

    private static final String KEY_CURRENT_TENANT = "KEY_CURRENT_TENANT";

    private static final Map<String, Object> mContext = Maps.newConcurrentMap();

    public String setCurrentTenantId(String tenantId) {
        synchronized (mContext) {
            if (mContext.get(KEY_CURRENT_TENANT) == null) {
                mContext.put(KEY_CURRENT_TENANT, tenantId);
                return tenantId;
            } else {
                return (String) mContext.get(KEY_CURRENT_TENANT);
            }
        }
    }

    public String getCurrentTenant() {
        return (String) mContext.get(KEY_CURRENT_TENANT);
    }

}
```



## 2.测试类

`MpslTenantApplicationTests.java`

```java
package com.streamslience.simples.tenant.mpsltenant;

import com.streamslience.simples.tenant.mpsltenant.dao.TenantDao;
import com.streamslience.simples.tenant.mpsltenant.dao.UserDao;
import com.streamslience.simples.tenant.mpsltenant.entity.TenantInfoEntity;
import com.streamslience.simples.tenant.mpsltenant.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MpslTenantApplicationTests {

    @Autowired
    private ApiContext apiContext;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TenantDao tenantDao;

    @Test
    public void contextLoads() {
    }

    @Before
    public void before() {
        System.out.println(
                apiContext.setCurrentTenantId(
                        UUID.randomUUID().toString().replaceAll("-", "")));
    }

    @Test
    public void insert_1() {
        UserInfoEntity user = new UserInfoEntity();
        user.setUserName("呵呵");
        Assert.assertTrue(userDao.insert(user) > 0);

        user = userDao.selectById(user.getUserId());
        log.info("insert user = {}", user);

        Assert.assertEquals(apiContext.getCurrentTenant(), user.getTenantId());
    }

    @Test
    public void insert_2() {
        TenantInfoEntity tenant = new TenantInfoEntity();
        tenant.setTenantId(apiContext.getCurrentTenant());
        tenant.setTenantName("我是一个租户");
        Assert.assertTrue(tenantDao.insert(tenant) > 0);
    }
}
```



