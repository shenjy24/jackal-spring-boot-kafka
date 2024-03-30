package com.jonas.kafka.controller;

import com.jonas.kafka.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProducerController
 *
 * @author shenjy
 * @time 2024/3/30 11:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {

    private final Producer producer;

    @PostMapping("/send")
    public String sendMessage(String topic, String message) {
        return producer.sendMessage(topic, message);
    }
}
