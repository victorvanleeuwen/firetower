package com.firetower.user_service;

import com.firetower.user_service.models.User;
import com.firetower.user_service.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepository) {
        return args -> {

            User user1 = new User("Gigazoom.inc","rkaines0@tinypic.com");           user1 = userRepository.save(user1);
            User user2 = new User("Jabberstorm.inc","mlowthian7@ow.ly");            user2 = userRepository.save(user2);
            User user3 = new User("Devify.inc","nstaresj@unicef.org");              user3 = userRepository.save(user3);
            User user4 = new User("Rotciv.inc","mromand6@howstuffworks.com");       user4 = userRepository.save(user4);
            User user5 = new User("Photobug.inc","crogank@whitehouse.gov");         user5 = userRepository.save(user5);
            User user6 = new User("Jetwire.inc","crogank@whitehouse.gov");          user6 = userRepository.save(user6);
            User user7 = new User("Yabox.inc","uchander5@blogger.com");             user7 = userRepository.save(user7);
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
