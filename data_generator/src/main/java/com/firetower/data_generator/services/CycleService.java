package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Server;
import com.firetower.data_generator.common.models.User;
import com.firetower.data_generator.models.ServerState;
import com.firetower.data_generator.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.TimerTask;

@Service
public class CycleService extends TimerTask {

    private List<User> users;
    private List<Server> servers;

    private Dictionary<Server,ServerState> serverStates;

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private StateService stateService;

    @Autowired
    private Messaginservice messaginservice;




    public CycleService() throws IOException {

        serverStates = new Hashtable<Server,ServerState>();

        users = generatorService.generateUser(100);

        for (User user: users) {

            servers.addAll(generatorService.generateServers(user.getId(),25));
        }



    }

    public void run(){
        System.out.println("timer tick");
    }
}
