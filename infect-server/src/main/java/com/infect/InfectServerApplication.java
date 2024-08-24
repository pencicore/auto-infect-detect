package com.infect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.infect.mapper")
@SpringBootApplication
public class InfectServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectServerApplication.class, args);
    }

}
