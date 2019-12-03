package com.streamslience.simples.crud.mpslcrud.configure;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author StreamSlience
 * @description Mybatis-Plus配置类
 * @creatdate 2019-12-02 13:54
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.streamslience.simples.crud.mpslcrud.dao.*")
public class MybatisPlusConfig {

    /**
     * <p>SQL环境效率插件</p>
     * 该插件在3.2.0以上版本移除，推荐使用第三方扩展功能
     *
     * @return
     */
//    @Bean
//    @Profile({"dev", "test"})//设置 dev test 环境开启
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }

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
