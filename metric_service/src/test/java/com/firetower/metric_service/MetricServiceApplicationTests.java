package com.firetower.metric_service;

import com.firetower.metric_service.repositories.MetricRepository;
import com.firetower.metric_service.services.MetricService;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MetricServiceApplicationTests {

    @Autowired
    private MetricRepository repo;

    @Test
    void contextLoads() {
    }

    @After
    public void cleanUp(){

        repo.deleteAll();
    }

}
