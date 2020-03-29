package com.firetower.log_service.controllers;

import com.firetower.common.Log;
import com.firetower.log_service.services.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
