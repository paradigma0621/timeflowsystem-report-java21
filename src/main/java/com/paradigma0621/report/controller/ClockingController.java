package com.paradigma0621.report.controller;

import com.paradigma0621.report.dto.ClockingDto;
import com.paradigma0621.report.dto.ClockingRegisterPublisherProtocolDto;
import com.paradigma0621.report.service.ClockingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clockings")
public class ClockingController {

    private final ClockingService service;

    @PostMapping("/sendRabbitMQMessage")
    public ResponseEntity<ClockingRegisterPublisherProtocolDto> sendRabbitMQMessageController(
            @RequestBody ClockingDto clockingDto) {
        ClockingRegisterPublisherProtocolDto protocolDto = service.sendRabbitMQMessage(clockingDto);
        return ResponseEntity.ok(protocolDto);
    }
}
