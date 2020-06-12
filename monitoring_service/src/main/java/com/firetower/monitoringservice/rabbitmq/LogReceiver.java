package com.firetower.monitoringservice.rabbitmq;

import com.firetower.monitoringservice.common.models.LogObject;
import com.firetower.monitoringservice.repositories.LogObjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogReceiver {

    @Autowired
    private LogObjectRepository repo;

    @RabbitListener(queues = "firetower.monitor.queue")
    public void receive(LogObject log) {

        repo.save(log);
    }
}
