package com.streamslience.simples.deleted.mpsllogicaldeleted;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.deleted.mpsllogicaldeleted")
public class MpslLogicaldeleteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslLogicaldeleteApplication.class, args);
    }

}
