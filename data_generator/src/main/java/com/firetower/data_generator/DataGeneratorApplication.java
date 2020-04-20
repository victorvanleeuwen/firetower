package com.firetower.data_generator;

import com.firetower.data_generator.services.CycleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;

@SpringBootApplication
@EnableEurekaClient
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
    public CommandLineRunner GeneratorDemo(CycleService cycleService){

        return  args -> {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(cycleService,(long)0,(long)6000); //tick every minute
        };

    }

}
