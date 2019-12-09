# Mybatis-Plus 攻击SQL阻断解析器

攻击SQL阻断解析器的作用在于防止恶意的全表更新或删除

## 1.配置攻击SQL阻断解析器

​	Mp自带的类`BlockAttackSqlParser`继承自`AbstractJsqlParser`已经实现了更新和删除方法下的防攻击SQL阻断，其源码如下：

```java
/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.extension.parsers;

import com.baomidou.mybatisplus.core.parser.AbstractJsqlParser;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;

/**
 * 攻击 SQL 阻断解析器
 *
 * @author hubin
 * @since 2018-07-17
 */
public class BlockAttackSqlParser extends AbstractJsqlParser {

    @Override
    public void processInsert(Insert insert) {
        // to do nothing
    }

    @Override
    public void processDelete(Delete delete) {
        Assert.notNull(delete.getWhere(), "Prohibition of full table deletion");
    }

    @Override
    public void processUpdate(Update update) {
        Assert.notNull(update.getWhere(), "Prohibition of table update operation");
    }

    @Override
    public void processSelectBody(SelectBody selectBody) {
        // to do nothing
    }
}

```

只需要创建加入`解析链(ISqlParser集合)`中即可实现功能，实现代码如下：

```java
List<ISqlParser> sqlParserList = new ArrayList<>();
//攻击SQL阻断解析器、加入解析链
sqlParserList.add(new BlockAttackSqlParser());
```



​	如果希望可以指定特定的表排除在阻断解析器外，可以创建匿名内部类`AbstractJsqlParser`覆写对应解析方法，自行实现代码如下：

```java
package com.streamslience.simples.sqlparser.mpslsqlparser.configure;

import com.baomidou.mybatisplus.core.parser.AbstractJsqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author StreamSlience
 * @description myabtisPlus 配置类
 * @creatdate 2019-12-01 20:57
 */
@Configuration
@MapperScan("com.streamslience.simples.sqlparser.mpslsqlparser.dao")
public class MybatisPlusConfig {

    //忽略防SQL攻击阻断
    static final int UPDATE = 0;
    static final int UPADTAE_DELETE = 1;
    static final int DELETE = 2;
    static List<String> UPDATE_LIST = new LinkedList();
    static List<String> DELETE_LIST = new LinkedList<>();

    static final Map<String, Integer> SQL_PARSER_INGORE_ATTACK = new ConcurrentHashMap<String, Integer>() {{
        put("user_info", UPDATE);
        put("goods_info", UPADTAE_DELETE);
        put("address_info", DELETE);
    }};

    static {
        SQL_PARSER_INGORE_ATTACK.forEach((s, o) -> {
            switch (o) {
                case UPDATE: { UPDATE_LIST.add(s); }break;
                case UPADTAE_DELETE: { UPDATE_LIST.add(s);DELETE_LIST.add(s); }break;
                case DELETE: { DELETE_LIST.add(s); }break;
            }
        });

    }

    /**
     * <p>分页插件、攻击SQL阻断解析器</p>
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();
        //攻击SQL阻断解析器、加入解析链
        //sqlParserList.add(new BlockAttackSqlParser());
        sqlParserList.add(new AbstractJsqlParser() {
            @Override
            public void processInsert(Insert insert) {
                //to do nothing
            }

            @Override
            public void processDelete(Delete delete) {
                //自定义跳过指定表
                if (DELETE_LIST.contains(delete.getTable().getName()))
                    return;
                Assert.notNull(delete.getWhere(), "Prohibition of full table deletion");
            }

            @Override
            public void processUpdate(Update update) {
                //自定义跳过指定表
                if (UPDATE_LIST.containsAll(update.getTables().stream().map(Table::getName).collect(Collectors.toList())))
                    return;
                Assert.notNull(update.getWhere(), "Prohibition of table update operation");
            }

            @Override
            public void processSelectBody(SelectBody selectBody) {
                //to do nothing
            }
        });
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

}

```



## 2.测试类实现

```java
package com.streamslience.simples.sqlparser.mpslsqlparser;

import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.AddressDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.GoodsDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.dao.UserDao;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.AddressInfoEntity;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.GoodsInfoEntity;
import com.streamslience.simples.sqlparser.mpslsqlparser.entity.UserInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MpslSqlParserApplicationTests {

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {

    }

    @Test
    public void Insert() {
        for (int i = 0; i < 20; ++i) {
            addressDao.insert(new AddressInfoEntity(String.format("地址-%d", i)));
            goodsDao.insert(new GoodsInfoEntity(String.format("物料-%d", i)));
            userDao.insert(new UserInfoEntity(String.format("用户-%d", i)));
        }
    }

    /**
     * 先执行一遍Insert()进行数据插入
     */
    @Test
    public void Update() {
        //有条件
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(addressDao).eq(AddressInfoEntity::getAddressName, "地址-1").update(new AddressInfoEntity("地址-1")));
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(userDao).eq(UserInfoEntity::getUserName, "用户-1").update(new UserInfoEntity("用户-1")));
        Assert.assertEquals(true, new LambdaUpdateChainWrapper<>(goodsDao).eq(GoodsInfoEntity::getGoodsName, "物料-1").update(new GoodsInfoEntity("物料-1")));

        //无条件
        try {
            addressDao.update(new AddressInfoEntity("地址-1"), new LambdaQueryChainWrapper<>(addressDao).getWrapper());
            System.out.println("---------------------------------------地址恶意更新成功---------------------------------------");
        } catch (RuntimeException e) {
            System.err.println("---------------------------------------地址恶意更新失败---------------------------------------");//OutPut
        }

        try {
            goodsDao.update(new GoodsInfoEntity("物料-1"), new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
            System.out.println("---------------------------------------物料恶意更新成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------物料恶意更新失败---------------------------------------");
        }

        try {
            userDao.update(new UserInfoEntity("用户-1"), new LambdaQueryChainWrapper<>(userDao).getWrapper());
            System.out.println("---------------------------------------用户恶意更新成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------用户恶意更新失败---------------------------------------");
        }


    }

    /**
     * 先清空数据库数据，在执行一遍Insert()插入数据
     */
    @Test
    public void Delete() {
        //有条件
        Assert.assertEquals(1, addressDao.delete(new LambdaQueryChainWrapper<>(addressDao).eq(AddressInfoEntity::getAddressName, "地址-1").getWrapper()));
        Assert.assertEquals(1, userDao.delete(new LambdaQueryChainWrapper<>(userDao).eq(UserInfoEntity::getUserName, "用户-1").getWrapper()));
        Assert.assertEquals(1, goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).eq(GoodsInfoEntity::getGoodsName, "物料-1").getWrapper()));

        //无条件
        try {
            addressDao.delete(new LambdaQueryChainWrapper<>(addressDao).getWrapper());
            System.out.println("---------------------------------------地址恶意删除成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------地址恶意删除失败---------------------------------------");
        }

        try {
            userDao.delete(new LambdaQueryChainWrapper<>(userDao).getWrapper());
            System.out.println("---------------------------------------用户恶意删除成功---------------------------------------");
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------用户恶意删除失败---------------------------------------");//OutPut
        }

        try {
            goodsDao.delete(new LambdaQueryChainWrapper<>(goodsDao).getWrapper());
            System.out.println("---------------------------------------物料恶意删除成功---------------------------------------");//OutPut
        } catch (RuntimeException r) {
            System.err.println("---------------------------------------物料恶意删除失败---------------------------------------");
        }
    }

}

```

