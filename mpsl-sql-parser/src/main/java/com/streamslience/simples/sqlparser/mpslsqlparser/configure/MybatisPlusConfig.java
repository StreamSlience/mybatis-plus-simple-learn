package com.streamslience.simples.sqlparser.mpslsqlparser.configure;

import com.baomidou.mybatisplus.core.injector.methods.Delete;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StreamSlience
 * @description myabtisPlus 配置类
 * @creatdate 2019-12-01 20:57
 */
@Configuration
public class MybatisPlusConfig {

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
        sqlParserList.add(new BlockAttackSqlParser() {
            public void processDelete(Delete delete) {

            }
        });
        paginationInterceptor.setSqlParserList(sqlParserList);

        //....

        return paginationInterceptor;

    }

}
