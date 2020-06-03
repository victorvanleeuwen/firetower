package com.firetower.log_service.rabbitmq;

import com.firetower.log_service.common.models.Log;
import com.firetower.log_service.services.AnalysisService;
import com.firetower.log_service.services.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Logreceiver {

    @Autowired
    private LogService logService;

    private Logger log = LoggerFactory.getLogger(Logreceiver.class);


    @RabbitListener(queues = "${firetower.rabbitmq.logs.queue}")
    public void receive(Log logobject) {

        logService.newLog(logobject);

    }
}
