package com.firetower.monitoringservice.services;

import com.firetower.monitoringservice.common.models.LogObject;
import com.firetower.monitoringservice.repositories.LogObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogObjectService {

    @Autowired
    private LogObjectRepository repo;

    public LogObjectService(){

    }
    public Iterable<LogObject> getallLogs(){
        return repo.findAll();
    }
}
