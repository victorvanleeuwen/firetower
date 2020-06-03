package com.firetower.metric_service.rabbitmq;

import com.firetower.metric_service.common.models.Metric;
import com.firetower.metric_service.common.models.MetricSet;
import com.firetower.metric_service.services.MetricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricReceiver {

    private Logger log = LoggerFactory.getLogger(MetricReceiver.class);

    @Autowired
    private MetricService metricService;


    @RabbitListener(queues = "${firetower.rabbitmq.metrics.queue}")
    public void receive(MetricSet metric) {

        metricService.newMetricSet(metric);
    }
}
