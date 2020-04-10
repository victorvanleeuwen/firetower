package com.firetower.data_generator;

import com.firetower.common.Server;
import com.firetower.common.User;
import com.firetower.data_generator.services.CycleService;
import com.firetower.data_generator.services.GeneratorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@SpringBootApplication
public class DataGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataGeneratorApplication.class, args);

    }

    @Bean
    public CommandLineRunner GeneratorDemo(CycleService cycleService){

        return  args -> {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(cycleService,(long)0,(long)6000); //tick every minute
        };

    }

}
