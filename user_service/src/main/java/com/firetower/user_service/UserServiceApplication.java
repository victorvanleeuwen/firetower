package com.firetower.user_service;



import com.firetower.user_service.common.models.User;
import com.firetower.user_service.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import static com.firetower.user_service.common.security.UserRole.ADMIN;
import static com.firetower.user_service.common.security.UserRole.USER;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserServiceApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        return args -> {

            User user1 = new User("Victor","victor@firetower.com",passwordEncoder.encode("testing"),true,true,true,true, ADMIN.getGrantedAuthorities());user1 = userRepository.save(user1);
        };
    }

    @Bean       // Do not (!!!!!) load balance between service instances running at different ports.
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        Duration time = Duration.ofMinutes(1);
        return restTemplateBuilder
                .setReadTimeout(time)
                .build();
    }
}
