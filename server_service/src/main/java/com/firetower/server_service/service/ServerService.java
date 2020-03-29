package com.firetower.server_service.service;

import com.firetower.common.Server;
import com.firetower.common.User;
import com.firetower.server_service.repositories.ServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void newServer(Server server){
        serverRepository.save(server);
    }
}
