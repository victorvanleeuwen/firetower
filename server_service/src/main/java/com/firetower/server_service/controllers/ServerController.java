package com.firetower.server_service.controllers;

import com.firetower.common.Server;
import com.firetower.server_service.service.ServerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
    public @ResponseBody Server getUserByCode(@RequestParam("id") Long id){
        return serverService.findServerById(id);
    }
    @RequestMapping(value = RestUriConstant.byCompany, method = RequestMethod.GET)
    public @ResponseBody Iterable<Server> getServerByUser(@RequestParam("id") Long id){
        return serverService.findServersByUser(id);
    }

}
