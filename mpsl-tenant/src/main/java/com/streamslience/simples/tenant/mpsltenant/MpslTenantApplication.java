package com.streamslience.simples.tenant.mpsltenant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.tenant.mpsltenant.dao")
public class MpslTenantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslTenantApplication.class, args);
    }

}
