package com.zll.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.zll.server.mapper"})
public class YebApplication {
    public static void main(String[] args) {

        SpringApplication.run(YebApplication.class,args);
    }
}
//47.113.231.228
