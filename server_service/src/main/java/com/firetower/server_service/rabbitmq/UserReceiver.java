package com.firetower.server_service.rabbitmq;

import com.firetower.server_service.service.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserReceiver {

    @Autowired
    private ServerService service;

    private Logger log = LoggerFactory.getLogger(UserReceiver.class);


    @RabbitListener(queues = "firetower.user.queue")
    public void receive(Long id) {

        log.info("Deleting servers of user: " + id);
        service.deleteServersWithUserId(id);
    }
}
