package com.firetower.monitoringservice.Controller;

import com.firetower.monitoringservice.common.models.LogObject;
import com.firetower.monitoringservice.services.LogObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {

    private LogObjectService service;

    @Autowired
    public LogController(LogObjectService service) {
        this.service = service;
    }

    @RequestMapping(value = RestURIConstant.all, method = RequestMethod.GET)
    public @ResponseBody
    Iterable<LogObject> getAll(){
          return service.getallLogs();
    }
}
