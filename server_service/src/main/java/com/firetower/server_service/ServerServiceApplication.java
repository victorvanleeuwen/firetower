package com.firetower.server_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerServiceApplication.class, args);
    }

    @Configuration
    class RestTemplateConfig {

        // Create a bean for restTemplate to call services
        @Bean
        @LoadBalanced        // Load balance between service instances running at different ports.
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

}
