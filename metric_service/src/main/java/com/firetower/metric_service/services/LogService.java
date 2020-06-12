package com.firetower.metric_service.services;

import com.firetower.metric_service.common.models.LogObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.logging.LogLevel;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {

    @Autowired
    private AmqpTemplate rabbittemplate;


    @Value("${firetower.rabbitmq.monitor.exchange}")
    private String Exchange;
    @Value("${firetower.rabbitmq.monitor.routingkey}")
    private String Routingkey;

    private final Logger log = LoggerFactory.getLogger(LogService.class);

    public LogService() {

    }
    public void log(LogLevel type, String message){

        switch (type)
        {
            case INFO:
                log.info(message);
                break;
            case DEBUG:
                log.debug(message);
                break;
            case ERROR:
                log.error(message);
                LogObject logObject = new LogObject(LogLevel.ERROR,new Date(),message);
                rabbittemplate.convertAndSend(Exchange,Routingkey,logObject);
                break;
            case TRACE:
                log.trace(message);
                break;

        }
    }


}
