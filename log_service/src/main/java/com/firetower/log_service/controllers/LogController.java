package com.firetower.log_service.controllers;

import com.firetower.log_service.common.models.Log;
import com.firetower.log_service.services.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogController {

    private final LogService logService;

    public LogController(LogService LogService) {
        this.logService = LogService;
    }


    @RequestMapping(value = RestURIConstant.all, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Log> allLogs() {
        return logService.allLogs();
    }

    @RequestMapping(value = RestURIConstant.findById, method = RequestMethod.GET)
    public @ResponseBody Log getLogById(@RequestParam("id") Long id){
        return logService.findLogById(id);
    }


    @RequestMapping(value = RestURIConstant.findByServer, method = RequestMethod.GET)
    public @ResponseBody Iterable<Log> getLogByUser(@RequestParam("id") Long id){
        return logService.findLogsByServer(id);
    }
    @RequestMapping(value = RestURIConstant.newLog, method = RequestMethod.POST)
    public @ResponseBody Log newLog(@RequestBody Log log){
        return logService.newLog(log);
    }

}
