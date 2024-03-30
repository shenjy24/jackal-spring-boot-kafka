package com.jonas.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Producer
 *
 * @author shenjy
 * @time 2024/3/30 11:14
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public String sendMessage(String topic, String message) {
        log.info("begin send, topic:{}, message:{}", topic, message);
        kafkaTemplate.send(topic, message).thenAcceptAsync(result -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("send message callback, result:{}", result);
        });
        log.info("send success, topic:{}, message:{}", topic, message);
        return "success";
    }
}
