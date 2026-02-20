package com.paradigma0621.report.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.clockings-registers-queue}")
    private String senderClockingQueue;

    @Bean
    public Queue senderClockingQueueBean(){
        return new Queue(senderClockingQueue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2MessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}