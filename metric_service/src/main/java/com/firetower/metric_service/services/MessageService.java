package com.firetower.metric_service.services;

import com.firetower.metric_service.common.models.Alert;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private AmqpTemplate rabbittemplate;

    @Value("${firetower.rabbitmq.alerts.exchange}")
    private String Exchange;
    @Value("${firetower.rabbitmq.alerts.routingkey}")
    private String Routingkey;

    @Value("${firetower.rabbitmq.alerts.queue}")
    private String queue;


    public MessageService() {

    }

    public void sendAlert(Alert alert){

        rabbittemplate.convertAndSend(Exchange,Routingkey,alert);
        System.out.println("Sending alert!");
    }
}
