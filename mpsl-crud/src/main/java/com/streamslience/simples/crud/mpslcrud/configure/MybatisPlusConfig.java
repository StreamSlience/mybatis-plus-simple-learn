package com.streamslience.simples.crud.mpslcrud.configure;

import org.mybatis.spring.annotation.MapperScan;
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

}
