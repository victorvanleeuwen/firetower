package com.firetower.alert_service.rabbitmq;

import com.firetower.alert_service.Service.AlertService;
import com.firetower.alert_service.common.models.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertReceiver {

    private Logger log = LoggerFactory.getLogger(AlertReceiver.class);

    @Autowired
    private AlertService alertService;


    @RabbitListener(queues = "${firetower.rabbitmq.alerts.queue}")
    public void receive(Alert alert) {
        log.info("Received alert: {}",alert.getMessage());

        alertService.newAlert(alert);


    }
}
