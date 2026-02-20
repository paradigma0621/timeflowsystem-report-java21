package com.paradigma0621.report.service;

import com.paradigma0621.report.dto.ClockingRegisterPublisherProtocolDto;
import com.paradigma0621.report.dto.ClockingDto;
import com.paradigma0621.report.exception.ClockingSenderRequestException;
import com.paradigma0621.report.messaging.rabbitmq.ClockingRegisterPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClockingService {

    private final ClockingRegisterPublisher publisher;

    public ClockingRegisterPublisherProtocolDto sendRabbitMQMessage(ClockingDto clockingDto) {
        try{
            publisher.clockingSender(clockingDto);
            var protocolo = UUID.randomUUID().toString();
            return new ClockingRegisterPublisherProtocolDto(protocolo);
        }catch (Exception e){
            throw new ClockingSenderRequestException(e.getMessage());
        }

    }
}
