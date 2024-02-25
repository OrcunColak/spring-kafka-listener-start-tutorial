package com.colak.springkafkaembeddedtesttutorial.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@Getter
@Slf4j
public class KafkaConsumer {

    public static final String CONSUMER_ID = "consumer1";

    @KafkaListener(id = CONSUMER_ID,
            topics = "topic1",
            groupId = "group1",
            autoStartup = "false",
            batch = "true")
    public void receive(List<ConsumerRecord<String, String>> consumerRecords) {
        log.info("List size : {}", consumerRecords.size());

        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            log.info("Values : {}", consumerRecord.value());
        }

    }
}
