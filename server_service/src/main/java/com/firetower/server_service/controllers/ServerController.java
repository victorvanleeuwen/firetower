package com.firetower.server_service.controllers;

import com.firetower.server_service.common.models.Server;
import com.firetower.server_service.service.ServerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ServerController {

    private final ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @RequestMapping(value = RestUriConstant.all, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Server> allServers() {
        return serverService.allservers();
    }

    @RequestMapping(value = RestUriConstant.byId, method = RequestMethod.GET)
    public @ResponseBody Server getServerByCode(@RequestParam("id") Long id){
        return serverService.findServerById(id);
    }

    @RequestMapping(value = RestUriConstant.servers, method = RequestMethod.GET)
    public @ResponseBody List<Server> getServers(){
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        final String email = (String) auth.getPrincipal();
        return serverService.getServers(email);
    }

    @RequestMapping(value = RestUriConstant.byCompany, method = RequestMethod.GET)
    public @ResponseBody Iterable<Server> getServerByUser(@RequestParam("id") Long id){
        return serverService.findServersByUser(id);
    }
    @RequestMapping(value = RestUriConstant.newServer, method = RequestMethod.POST)
    public @ResponseBody Server newServer(@RequestBody Server server){
        return serverService.newServer(server);
    }

    @RequestMapping(value = RestUriConstant.newServers, method = RequestMethod.POST)
    public void newSevers(@RequestBody List<Server> servers){
        serverService.newServers(servers);
    }

    @RequestMapping(value = RestUriConstant.generateServers,method = RequestMethod.GET)
    public void generateServers(@RequestParam("id") Long id,@RequestParam("amount") Integer amount) throws IOException {
          serverService.generateServers(id,amount);
    }

}
