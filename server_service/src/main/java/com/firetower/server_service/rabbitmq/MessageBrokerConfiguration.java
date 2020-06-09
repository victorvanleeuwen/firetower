package com.firetower.server_service.rabbitmq;

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

    @Value("${firetower.rabbitmq.server.metric.queue}")
    private String metricQueue;
    @Value("${firetower.rabbitmq.server.metric.exchange}")
    private String metricExchange;
    @Value("${firetower.rabbitmq.server.metric.routingkey}")
    private String metricRoutingKey;

    @Value("${firetower.rabbitmq.server.log.queue}")
    private String logQueue;
    @Value("${firetower.rabbitmq.server.log.exchange}")
    private String logExchange;
    @Value("${firetower.rabbitmq.server.log.routingkey}")
    private String logRoutingKey;

    @Bean
    public Queue metricQueue() {
        return new Queue(metricQueue);
    }

    @Bean
    public Queue LogQueue() {
        return new Queue(logQueue);
    }

    @Bean
    public DirectExchange metricExchange() {
        return new DirectExchange(metricExchange);
    }

    @Bean
    public DirectExchange LogExchange() {
        return new DirectExchange(logExchange);
    }

    @Bean
    Binding metricBinding(@Qualifier("metricQueue") Queue queue,@Qualifier("metricExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(metricRoutingKey);
    }

    @Bean
    Binding logBinding(@Qualifier("LogQueue")Queue queue,@Qualifier("LogExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(logRoutingKey);
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
