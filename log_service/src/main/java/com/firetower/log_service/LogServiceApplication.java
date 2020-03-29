package com.firetower.log_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan({"com.firetower.common","com.firetower.log_service"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogServiceApplication.class, args);
    }

}
