package com.firetower.server_service.service;

import com.firetower.server_service.repositories.ServerRepository;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    private final ServerRepository serverRepository;

    public ServerService(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }
}
