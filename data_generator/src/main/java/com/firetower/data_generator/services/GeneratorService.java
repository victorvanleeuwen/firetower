package com.firetower.data_generator.services;

import com.firetower.common.MetricSet;
import com.firetower.common.Server;
import com.firetower.common.User;
import com.firetower.common.enums.OperatingSystemType;
import com.firetower.common.security.UserRole;
import com.firetower.common.utils.RandomUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@Service
public class GeneratorService {



    public static List<Server> generateServers(Long userId, int amount) throws IOException {


        Stream<String> serverlines = Files.lines(Paths.get("./data_generator/src/main/java/com/firetower/data_generator/servernames.txt"));
        List<String> servernames = serverlines.collect(Collectors.toList());



        List<Server> servers = new ArrayList<Server>();
        Integer i = 0;
        while (i < amount) {
            String name = (String) RandomUtil.getRandomElement(servernames);
            String ip = RandomUtil.generateRandomIp();
            OperatingSystemType os = RandomUtil.randomEnum(OperatingSystemType.class);
            Server server = new Server();
            servers.add(server);
            i++;
        }
        return servers;

    }

    public static List<User> generateUser(int amount) throws IOException{

        Stream<String> userlines = Files.lines(Paths.get("./data_generator/src/main/java/com/firetower/data_generator/companynames.txt"));
        List<String> usernames = userlines.collect(Collectors.toList());

        Stream<String> passwordlines = Files.lines(Paths.get("./data_generator/src/main/java/com/firetower/data_generator/passwords.txt"));
        List<String> passwords = passwordlines.collect(Collectors.toList());

        Stream<String> emaillines = Files.lines(Paths.get("./data_generator/src/main/java/com/firetower/data_generator/emails.txt"));
        List<String> emails = emaillines.collect(Collectors.toList());



        List<User> users = new ArrayList<User>();
        Integer i = 0;
        while (i < amount){
            String name = (String) RandomUtil.getRandomElement(usernames);
            String email = (String) RandomUtil.getRandomElement(emails);
            String password = (String) RandomUtil.getRandomElement(passwords);
            User user = new User(name,email,password,true,true,true,true,UserRole.USER.getGrantedAuthorities());
            users.add(user);
            i++;
        }
        return users;
    }

}
