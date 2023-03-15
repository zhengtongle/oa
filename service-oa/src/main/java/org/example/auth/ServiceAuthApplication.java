package org.example.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceAuthApplication {
    public static void main(String[] args) {
        System.out.println("HelloWorld");
        SpringApplication.run(ServiceAuthApplication.class);
    }
}
