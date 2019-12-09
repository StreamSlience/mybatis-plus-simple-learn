package com.streamslience.simples.dynamic.mpsldynamicdatasource.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author StreamSlience
 * @description MybatisPlus配置类
 * @creatdate 2019-12-09 10:12
 */
@Configuration
@MapperScan("com.streamslience.simples.dynamic.mpsldynamicdatasource.dao")
public class MybatisPlusConfig {
}
