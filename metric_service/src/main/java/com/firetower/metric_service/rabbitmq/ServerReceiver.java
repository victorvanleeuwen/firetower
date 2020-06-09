package com.firetower.metric_service.rabbitmq;

import com.firetower.metric_service.services.MetricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerReceiver {
    @Autowired
    private MetricService service;

    private Logger log = LoggerFactory.getLogger(ServerReceiver.class);


    @RabbitListener(queues = "${firetower.rabbitmq.server.queue}")
    public void receive(Long id) {

        log.info("Deleting metrics of server: " + id);
        service.deleteMetricsByServerId(id);
    }
}
