package com.firetower.user_service;


import com.firetower.common.User;
import com.firetower.user_service.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import static com.firetower.common.security.UserRole.USER;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,RepositoryRestMvcAutoConfiguration.class})
@EnableEurekaClient
@ComponentScan({"com.firetower.common","com.firetower.user_service"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        return args -> {

            User user1 = new User("Gigazoom.inc","rkaines0@tinypic.com",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());           user1 = userRepository.save(user1);
            User user3 = new User("Devify.inc","nstaresj@unicef.org",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());              user3 = userRepository.save(user3);
            User user4 = new User("Rotciv.inc","mromand6@howstuffworks.com",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());       user4 = userRepository.save(user4);
            User user5 = new User("Photobug.inc","crogank@whitehouse.gov",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());         user5 = userRepository.save(user5);
            User user6 = new User("Jetwire.inc","crogank@whitehouse.gov",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());          user6 = userRepository.save(user6);
            User user7 = new User("Yabox.inc","uchander5@blogger.com",passwordEncoder.encode("testing"),true,true,true,true, USER.getGrantedAuthorities());             user7 = userRepository.save(user7);
        };
    }

    @Configuration
    class RestTemplateConfig {
        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }
}
