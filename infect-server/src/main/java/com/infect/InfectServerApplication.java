package com.infect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.infect.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class InfectServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectServerApplication.class, args);
    }

}
