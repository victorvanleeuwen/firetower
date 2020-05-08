package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Log;
import com.firetower.data_generator.common.models.Metric;
import com.firetower.data_generator.common.models.MetricSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class Messaginservice {

    private final RestTemplate restTemplate;


    public Messaginservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendLogs(List<Log> input){

        restTemplate.postForObject("http://log-service/newLogs",input,ResponseEntity.class);
    }

    public void sendmetrics(List<MetricSet>input) {

     restTemplate.postForObject("http://metric-service/newMetrics",input,ResponseEntity.class);

    }


}
