package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Log;
import com.firetower.data_generator.common.models.Metric;
import com.firetower.data_generator.common.models.MetricSet;
import com.firetower.data_generator.common.utils.HostProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;


public class Messaginservice {

    private final RestTemplate restTemplate;

    @Autowired
    private LogService log;


    public Messaginservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendLogs(List<Log> input){

        try{
            restTemplate.postForObject(HostProvider.getLogService()+"newLogs",input,ResponseEntity.class);
        }
        catch (Exception e){
            log.log(LogLevel.ERROR,"Failed to send logs");
        }
    }

    public void sendmetrics(List<MetricSet>input) {

        try{
            restTemplate.postForObject(HostProvider.getMetricService()+"newMetrics",input,ResponseEntity.class);
        }
        catch (Exception e){

            log.log(LogLevel.ERROR,"Failed to send metrics");
        }
    }
}
