package com.jonas.kafka.consumer;

import com.jonas.kafka.config.KafkaCommon;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Consumer
 *
 * @author shenjy
 * @time 2024/3/30 11:17
 */
@Slf4j
@Component
public class Consumer {

    // 消费监听
    @KafkaListener(topics = {KafkaCommon.TOPIC})
    public void onMessage(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("简单消费 Topic：{}，分区：{}，消息：{}", record.topic(), record.partition(), record.value());
    }
}
