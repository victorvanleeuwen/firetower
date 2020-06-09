package com.firetower.server_service.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMessenger {

    @Autowired
    private AmqpTemplate rabbittemplate;

    @Value("${firetower.rabbitmq.server.metric.exchange}")
    private String serverMetricExchange;
    @Value("${firetower.rabbitmq.server.metric.routingkey}")
    private String serverMetricRoutingkey;

    @Value("${firetower.rabbitmq.server.log.exchange}")
    private String serverLogExchange;
    @Value("${firetower.rabbitmq.server.log.routingkey}")
    private String serverLogRoutingkey;

    public void deleteserver(Long id){
        System.out.println("Deleting now");
        deleteServerLogs(id);
        deleteServerMetrics(id);
    }

    private void deleteServerLogs(Long id){
        rabbittemplate.convertAndSend(serverLogExchange,serverLogRoutingkey,id);
    }

    private void deleteServerMetrics(Long id){
        rabbittemplate.convertAndSend(serverMetricExchange,serverMetricRoutingkey,id);
    }
}
