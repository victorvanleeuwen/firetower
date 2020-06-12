package com.firetower.monitoringservice.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBrokerConfiguration {

    @Value("${firetower.rabbitmq.monitor.queue")
    private String monitorQueue;
    @Value("${firetower.rabbitmq.monitor.exchange}")
    private String monitorExchange;
    @Value("${firetower.rabbitmq.monitor.routingkey}")
    private String monitorRoutingKey;



    @Bean
    public Queue metricQueue() {
        return new Queue(monitorQueue);
    }

    @Bean
    public DirectExchange metricExchange() {
        return new DirectExchange(monitorExchange);
    }



    @Bean
    Binding metricBinding( Queue queue,DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(monitorRoutingKey);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
