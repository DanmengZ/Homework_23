package com.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.sys.mapper")
@SpringBootApplication
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }

}
