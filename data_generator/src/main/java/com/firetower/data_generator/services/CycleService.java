package com.firetower.data_generator.services;

import com.firetower.common.Server;
import com.firetower.common.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

@Service
public class CycleService extends TimerTask {

    private List<User> users;
    private List<Server> servers;


    public CycleService() throws IOException {

        users = new ArrayList<>();
        servers = new ArrayList<>();
        // generate 100 users
        users = GeneratorService.generateUser(100);

        // for each user generate 25 servers
        for (User user:users) {
            servers.addAll(GeneratorService.generateServers(user.getId(),25));


        }
    }

    public void run(){
        System.out.println("timer tick");
    }
}
