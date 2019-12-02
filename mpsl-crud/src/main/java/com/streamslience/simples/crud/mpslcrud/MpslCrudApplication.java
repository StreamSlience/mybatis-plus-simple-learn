package com.streamslience.simples.crud.mpslcrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.crud.mpslcrud.dao")
public class MpslCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslCrudApplication.class, args);
    }

}
