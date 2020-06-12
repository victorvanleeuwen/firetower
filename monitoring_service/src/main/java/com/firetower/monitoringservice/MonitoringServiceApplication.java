package com.firetower.monitoringservice;

import com.firetower.monitoringservice.common.models.LogObject;
import com.firetower.monitoringservice.repositories.LogObjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.logging.LogLevel;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MonitoringServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(LogObjectRepository repo) {
        return args -> {

            LogObject log = new LogObject(LogLevel.ERROR,new Date(),"Test error");
            repo.save(log);
        };
    }

}
