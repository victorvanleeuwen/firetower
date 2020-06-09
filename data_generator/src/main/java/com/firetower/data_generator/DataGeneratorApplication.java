package com.firetower.data_generator;

import com.firetower.data_generator.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@EnableSpringConfigured
public class DataGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataGeneratorApplication.class, args);

    }
    @Configuration
    class RestTemplateConfig {
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    @Bean
    public CommandLineRunner GeneratorDemo(RestTemplate restTemplate, RabbitMessenger rabbitMessenger){

        return  args -> {

            Timer timer = new Timer();
            Messaginservice messaginservice = new Messaginservice(restTemplate);
            GeneratorService generatorService = new GeneratorService(restTemplate);
            StateService stateService = new StateService();
            CycleService cycleService = new CycleService(generatorService,stateService,messaginservice, rabbitMessenger );
            timer.scheduleAtFixedRate(cycleService,(long)0,(long)6000); //tick every minute
        };
    }
}
