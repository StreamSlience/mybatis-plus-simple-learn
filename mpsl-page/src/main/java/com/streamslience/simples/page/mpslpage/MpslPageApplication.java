package com.streamslience.simples.page.mpslpage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.page.mpslpage.dao")
public class MpslPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslPageApplication.class, args);
    }

}
