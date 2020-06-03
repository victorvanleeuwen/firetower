package com.firetower.log_service.services;

import com.firetower.log_service.common.models.Log;
import com.firetower.log_service.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {


    private final LogRepository logRepository;
    private final AnalysisService analysisService;

    public LogService(LogRepository logRepository, AnalysisService analysisService) {
        this.logRepository = logRepository;
        this.analysisService = analysisService;
    }


    public Iterable<Log> allLogs(){
        return logRepository.findAll();
    }

    public Iterable<Log> findLogsByServer(Long id){
        return logRepository.findLogsByServerId(id);
    }
    public Log findLogById(Long id){
        return logRepository.findLogById(id);
    }

    public Log newLog(Log Log){
        Log output = logRepository.save(Log);
        analysisService.analyseLog(output);
        return output;
    }
    public void newLogs(List<Log> input){

        for (Log log:input) {
            newLog(log);

        }
    }

}
