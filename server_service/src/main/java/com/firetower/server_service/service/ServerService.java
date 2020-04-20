package com.firetower.server_service.service;


import com.firetower.server_service.common.enums.OperatingSystemType;
import com.firetower.server_service.common.models.Server;
import com.firetower.server_service.common.utils.RandomUtil;
import com.firetower.server_service.repositories.ServerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    public Iterable<Server> allservers(){
        return serverRepository.findAll();
    }

    public Iterable<Server> findServersByUser(Long id){
        return serverRepository.findServersByUserId(id);
    }
    public Server findServerById(Long Id){
        return serverRepository.findServerById(Id);
    }

    public Server newServer(Server server){
         return serverRepository.save(server);
    }

    public void newServers(List<Server> servers){
        serverRepository.saveAll(servers);
    }

    public void generateServers(Long id,int amount) throws IOException {

        Stream<String> serverlines = Files.lines(Paths.get("./data_generator/src/main/java/com/firetower/data_generator/servernames.txt"));
        List<String> servernames = serverlines.collect(Collectors.toList());



        List<Server> servers = new ArrayList<Server>();
        Integer i = 0;
        while (i < amount) {
            String name = (String) RandomUtil.getRandomElement(servernames);
            String ip = RandomUtil.generateRandomIp();
            OperatingSystemType os = RandomUtil.randomEnum(OperatingSystemType.class);
            Server server = new Server();
            serverRepository.save(server);
            i++;
        }


    }
}
