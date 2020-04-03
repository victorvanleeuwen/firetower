package com.firetower.data_generator.services;

import com.firetower.common.Server;
import com.firetower.common.User;
import com.firetower.common.enums.OperatingSystemType;
import com.firetower.common.security.UserRole;
import com.firetower.common.utils.RandomUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class generatorService {


    public static List<Server> generateServers(Long userId, int amount, List<String> servernames){
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

    public static List<User> generateUser(int amount, List<String> usernames,List<String> emails,List<String> passwords){
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
