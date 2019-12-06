package com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.configure;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author StreamSlience
 * @description mybatisPlus配置类
 * @creatdate 2019-12-06 17:43
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.dao")
public class MybatisPlusConfig {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
