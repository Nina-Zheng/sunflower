package com.znt.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.znt.demo.dao.mapping")
public class Applicaiton {

    public static void main(String[] agrs){
        SpringApplication application = new SpringApplication(Applicaiton.class);
        application.run(agrs);
    }
}
