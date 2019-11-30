package com.streamslience.simples.metainfo.mpslautofillmetainfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.metainfo.mpslautofillmetainfo.dao")
public class MpslAutoFillMetainfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslAutoFillMetainfoApplication.class, args);
    }

}
