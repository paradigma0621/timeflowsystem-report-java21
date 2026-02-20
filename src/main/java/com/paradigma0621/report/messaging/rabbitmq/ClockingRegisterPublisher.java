package com.paradigma0621.report.messaging.rabbitmq;

import com.paradigma0621.report.dto.ClockingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClockingRegisterPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue senderClockingQueueBean;

    public void clockingSender(ClockingDto clockingDto) {
        rabbitTemplate.convertAndSend(senderClockingQueueBean.getName(), clockingDto);
    }

}