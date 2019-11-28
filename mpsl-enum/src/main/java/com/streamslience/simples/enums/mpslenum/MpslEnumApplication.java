package com.streamslience.simples.enums.mpslenum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.streamslience.simples.enums.mpslenum.dao")
public class MpslEnumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslEnumApplication.class, args);
    }

}
