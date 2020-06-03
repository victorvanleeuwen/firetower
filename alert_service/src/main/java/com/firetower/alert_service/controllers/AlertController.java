package com.firetower.alert_service.controllers;

import com.firetower.alert_service.Service.AlertService;
import com.firetower.alert_service.common.models.Alert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlertController {

    private AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @RequestMapping(value = RestURIConstant.getById, method = RequestMethod.GET)
    public @ResponseBody
    Alert findAlertById(Long id){
        return alertService.findAlertById(id);
    }

    @RequestMapping(value = RestURIConstant.getByServer, method = RequestMethod.GET)
    public @ResponseBody List<Alert> findAlertsByServerId (Long serverId){

        return alertService.findAlertsByServerId(serverId);
    }

    @RequestMapping(value = RestURIConstant.all, method = RequestMethod.GET)
    public @ResponseBody Iterable<Alert> findAlerts(){
        return alertService.all();
    }


    @RequestMapping(value = RestURIConstant.newAlert, method = RequestMethod.POST)
    public @ResponseBody Alert newAlert(Alert newalert){
        return alertService.newAlert(newalert);
    }

    @RequestMapping(value = RestURIConstant.getByServers,method = RequestMethod.POST)
    public @ResponseBody List<Alert> findAlertsByServerIds(@RequestBody List<Long> values){
        return alertService.findAlertsByServerIds(values);
    }

    @RequestMapping(value = RestURIConstant.delete, method = RequestMethod.DELETE)
    public void deleteAlert(@RequestParam Long id){
        alertService.deleteAlert(id);
    }


}
