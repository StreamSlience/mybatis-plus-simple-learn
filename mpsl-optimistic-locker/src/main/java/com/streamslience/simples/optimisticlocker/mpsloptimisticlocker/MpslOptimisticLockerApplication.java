package com.streamslience.simples.optimisticlocker.mpsloptimisticlocker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.optimisticlocker.mpsloptimisticlocker.dao")
public class MpslOptimisticLockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslOptimisticLockerApplication.class, args);
    }

}
