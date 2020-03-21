package com.firetower.datagenerator;

import com.firetower.common.models.Company;
import com.firetower.datagenerator.repositories.CompanyRepository;
import com.firetower.datagenerator.services.GeneratorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DatageneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatageneratorApplication.class, args);
    }

    @Bean
    public CommandLineRunner GeneratorDemo(CompanyRepository companyRepository, GeneratorService generatorService){

        return  args -> {

            /**
             *  Servers sturen constant metrics (om de minuut). mits de server aan staat.
             *  Om de minuut is er ook de kans dat een of meerdere events plaats vinden.
             *  De events kunnen op verschillend niveau zijn, system, security of application
             *
             */

            Stream<String> complines = Files.lines(Paths.get("./mockdata/companynames.txt"));
            List<String> compnames = complines.collect(Collectors.toList());
            Stream<String> serverlines = Files.lines(Paths.get("./mockdata/servernames.txt"));
            List<String> servernames = serverlines.collect(Collectors.toList());


            List<Company> comps = generatorService.startGeneration(compnames,servernames,100,20);
            System.out.println(comps);

            Company comp1 = new Company("testing");
            comp1 = companyRepository.save(comp1);
            System.out.println(servernames.size());
            System.out.println(compnames.size());





        };

    }

}
