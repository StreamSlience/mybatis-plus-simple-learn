package com.streamslience.simples.enums.mpslenum.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author StreamSlience
 * @description myabtisPlus 配置类
 * @creatdate 2019-11-28 12:50
 */
@Configuration
@MapperScan(basePackages = "com.streamslience.simples.enums.mpslenum.dao")
public class MybatisPlusConfig {

}
