package com.firetower.data_generator.services;

import com.firetower.data_generator.common.models.Log;
import com.firetower.data_generator.common.models.Metric;
import com.firetower.data_generator.common.models.MetricSet;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMessenger {

    @Autowired
    private AmqpTemplate rabbittemplate;

    @Value("${firetower.rabbitmq.logs.exchange}")
    private String logExchange;
    @Value("${firetower.rabbitmq.logs.routingkey}")
    private String logRoutingkey;

    @Value("${firetower.rabbitmq.metrics.exchange}")
    private String metricExchange;

    @Value("${firetower.rabbitmq.metrics.routingkey}")
    private String metricRoutingkey;

    private void sendLog(Log log){
        rabbittemplate.convertAndSend(logExchange,logRoutingkey,log);
    }

    private void sendMetric(MetricSet metric){
        rabbittemplate.convertAndSend(metricExchange,metricRoutingkey,metric);
    }

    public void sendLogs(List<Log> logs){
        for (Log log:logs) {
            sendLog(log);
        }
    }

    public void sendMetrics(List<MetricSet> metrics){
        for (MetricSet metric: metrics) {
            sendMetric(metric);
        }
    }
}
