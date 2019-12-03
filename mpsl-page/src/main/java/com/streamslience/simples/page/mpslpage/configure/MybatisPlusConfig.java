package com.streamslience.simples.page.mpslpage.configure;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author StreamSlience
 * @description MybatisPlus配置类
 * @creatdate 2019-12-03 11:25
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.streamslience.simples.page.mpslpage.dao")
public class MybatisPlusConfig {

    /**
     * <p>分页插件</p>
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求的页面大于最大也后操作，true调回到首页，false继续请求 默认false
        //paginationInterceptor.setOverflow(false);
        //设置最大单页限制数量，默认500条，-1不受限制
        //pageinationInterceptor.setLimit(500);
        return paginationInterceptor;
    }

}
