package com.firetower.log_service.services;

import com.firetower.common.Log;
import com.firetower.log_service.repositories.LogRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {


    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public Iterable<Log> allLogs(){
        return logRepository.findAll();
    }

    public Iterable<Log> findLogsByServer(Long id){
        return logRepository.findLogsByServer_id(id);
    }
    public Log findLogById(Long id){
        return logRepository.findLogById(id);
    }

    public void newLog(Log Log){
        logRepository.save(Log);
    }

}
