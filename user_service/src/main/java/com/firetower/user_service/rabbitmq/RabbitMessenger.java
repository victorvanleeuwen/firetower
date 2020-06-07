package com.firetower.user_service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessenger {
    @Autowired
    private AmqpTemplate rabbittemplate;

    @Value("${firetower.rabbitmq.user.exchange}")
    private String serverExchange;
    @Value("${firetower.rabbitmq.user.routingkey}")
    private String serverRoutingkey;


    public void deleteUser(Long id){
        rabbittemplate.convertAndSend(serverExchange,serverRoutingkey,id);
    }
}

