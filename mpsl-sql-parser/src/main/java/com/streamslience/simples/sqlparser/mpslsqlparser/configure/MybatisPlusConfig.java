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
     *2.
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
