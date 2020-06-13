package com.firetower.server_service.service;


import com.firetower.server_service.common.enums.OperatingSystemType;
import com.firetower.server_service.common.models.Server;
import com.firetower.server_service.common.utils.HostProvider;
import com.firetower.server_service.common.utils.RandomUtil;
import com.firetower.server_service.rabbitmq.RabbitMessenger;
import com.firetower.server_service.repositories.ServerRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServerService {

    @Autowired
    private RestTemplate restTemplate;

    private final ServerRepository serverRepository;

    @Autowired
    private LogService log;

    @Autowired
    private RabbitMessenger messenger;

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
    
    public List<Server> getServers(String email) throws  IOException{
        try{
            Long id = restTemplate.getForObject(HostProvider.getUserService()+"/getId?email="+email, Long.class);
            return serverRepository.findServersByUserId(id);
        }
        catch(Exception e)
        {
            log.log(LogLevel.ERROR,"Failed to retrieve servers");
            throw new IOException(e.getMessage());
        }

    }
    public void deleteServersWithUserId(Long Id){
        
        List<Server> servers = serverRepository.findServersByUserId(Id);
        for (Server server: servers) {
            messenger.deleteserver(server.getId());
        }
        serverRepository.deleteAll(servers);

    }
    
    public String deleteServerWithServerId(Long id){

        try{
            messenger.deleteserver(id);
            serverRepository.delete(serverRepository.findServerById(id));
            return "succes";
        }
        catch (Exception e){
            return "failed";
        }

    }

    public Server newServer(Server server){
         return serverRepository.save(server);
    }

    public void newServers(List<Server> servers){
        serverRepository.saveAll(servers);
    }

    public void generateServers(Long id,int amount) throws IOException {

        try{
            Stream<String> serverlines = Files.lines(Paths.get("./server_service/src/main/java/com/firetower/server_service/servernames.txt"));
            List<String> servernames = serverlines.collect(Collectors.toList());



            List<Server> servers = new ArrayList<Server>();
            Integer i = 0;
            while (i < amount) {
                String name = (String) RandomUtil.getRandomElement(servernames);
                String ip = RandomUtil.generateRandomIp();
                OperatingSystemType os = RandomUtil.randomEnum(OperatingSystemType.class);
                Server server = new Server(name,ip,id,os,true);
                serverRepository.save(server);
                System.out.println("generated server");
                i++;
            }
        }
        catch (Exception e){
            log.log(LogLevel.ERROR,"Failed to generate servers");
            throw new IOException(e.getMessage());
        }
    }
}
