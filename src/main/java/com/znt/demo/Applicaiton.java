package com.znt.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Applicaiton {

    public static void main(String[] agrs){
        SpringApplication application = new SpringApplication(Applicaiton.class);
        application.run(agrs);
    }
}
