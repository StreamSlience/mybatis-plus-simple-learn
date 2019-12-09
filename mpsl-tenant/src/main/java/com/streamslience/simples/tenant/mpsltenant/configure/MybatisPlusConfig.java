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
    //过滤表的表名集合(即不需要自动注入租户主键的表，例如存放租户信息的表)
    private static final List<String> IGNORE_TENANT_TABLES =
            Lists.newArrayList("tenant_info");

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /*
            测试多租户 SQL 解析处理拦截器
            这里固定写成租户1 实际情况可以从cookie里读取，因此数据看不到
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
                MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
                //过滤自定义查询此时无租户信息约束???
                if ("com.streamslience.simples.tenant.mpsltenant.dao".equals(ms.getId())) {
                    return true;
                }
                return false;
            }
        });
        return paginationInterceptor;
    }

}
