package com.firetower.log_service.services;

import com.firetower.log_service.common.models.Alert;
import org.bouncycastle.math.Primes;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
