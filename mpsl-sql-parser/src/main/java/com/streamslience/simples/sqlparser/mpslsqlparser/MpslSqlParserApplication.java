package com.streamslience.simples.sqlparser.mpslsqlparser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.streamslience.simples.sqlparser.mpslsqlparser.dao")
public class MpslSqlParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpslSqlParserApplication.class, args);
    }

}
