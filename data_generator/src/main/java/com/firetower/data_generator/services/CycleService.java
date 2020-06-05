package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Log;
import com.firetower.data_generator.common.models.Server;
import com.firetower.data_generator.common.models.User;
import com.firetower.data_generator.models.ServerState;

import java.io.IOException;
import java.util.*;


public class CycleService extends TimerTask {

    private List<User> users;
    private List<Server> servers;

    private Map<Server,ServerState> serverStates;


    private GeneratorService generatorService;


    private StateService stateService;


    private Messaginservice messaginservice;

    private RabbitMessenger rabbitMessenger;

    public static Boolean paused = true;


    public CycleService(GeneratorService generatorService, StateService stateService, Messaginservice messaginservice, RabbitMessenger rabbitMessenger) throws IOException {
        this.generatorService = generatorService;
        this.stateService = stateService;
        this.messaginservice = messaginservice;
        this.rabbitMessenger = rabbitMessenger;


        //setup a dictionary where a server and serverstate are connected to each other.
        serverStates = new Hashtable<Server,ServerState>();

        // Make a call to the user service where x amount of users are generated.
        users = this.generatorService.generateUser(4);

        // for each user generate x amount of servers
        for (User user: users) {

            generatorService.startGeneration(user.getId(),5);
        }
        servers =generatorService.collectServers();

        //start the setup procedure. This will provide a serverstate to a server. With a certain lifespan.
        serverStates = this.stateService.setup(servers);


    }

    public void run(){
        System.out.println("timer tick");

        if(!CycleService.paused){
            // If the service is not paused run the program

            System.out.println("Starting to generate Logs and send them to the logging service");
            List<Log> logs = generatorService.generateLogs(serverStates);
//            messaginservice.sendLogs(logs);
            rabbitMessenger.sendLogs(logs);

            System.out.println("Starting to generate metrics and send them to the metric service");
            rabbitMessenger.sendMetrics(generatorService.generateMetricSet(serverStates));

            System.out.println("New cycle in the generator");
            serverStates = stateService.cycle(serverStates);

        }
    }
}
