package com.firetower.alert_service;

import com.firetower.alert_service.common.models.Alert;
import com.firetower.alert_service.common.models.AlertSeverity;
import com.firetower.alert_service.repository.AlertRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AlertServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AlertRepository alertRepository) {
        return args -> {
            Alert alert1 = new Alert("High amount of failed security configuration changes.",AlertSeverity.High,new Date(),1L);
            Alert alert2 = new Alert("High amount of failed attempts to update user.",AlertSeverity.High,new Date(),1L);
            Alert alert3 = new Alert("RAM metric is high",AlertSeverity.High,new Date(),2L);

            alertRepository.save(alert1);
            alertRepository.save(alert2);
            alertRepository.save(alert3);
        };
    }

}
