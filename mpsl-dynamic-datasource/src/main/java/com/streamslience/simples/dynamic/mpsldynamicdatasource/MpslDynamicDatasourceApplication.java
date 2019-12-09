package com.streamslience.simples.dynamic.mpsldynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.dynamic.mpsldynamicdatasource.dao")
public class MpslDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslDynamicDatasourceApplication.class, args);
    }

}
