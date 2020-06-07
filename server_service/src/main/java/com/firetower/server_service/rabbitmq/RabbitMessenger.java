package com.firetower.server_service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessenger {

    @Autowired
    private AmqpTemplate rabbittemplate;

    @Value("${firetower.rabbitmq.server.exchange}")
    private String serverExchange;
    @Value("${firetower.rabbitmq.server.routingkey}")
    private String serverRoutingkey;


    public void deleteServer(Long id){
        rabbittemplate.convertAndSend(serverExchange,serverRoutingkey,id);
    }
}
