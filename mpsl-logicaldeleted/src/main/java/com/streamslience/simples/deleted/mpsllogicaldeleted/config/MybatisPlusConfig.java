package com.streamslience.simples.deleted.mpsllogicaldeleted.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author StreamSlience
 * @description MybatisPlus配置类
 * @creatdate 2019-11-30 16:22
 */
@Configuration
@MapperScan("com.streamslience.simples.deleted.mpsllogicaldeleted.dao")
public class MybatisPlusConfig {

    /**
     * <p>分页插件</p>
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //开启count的join优化，只针对left join
        return new PaginationInterceptor().setCountSqlParser(new JsqlParserCountOptimize(true));
    }
}
