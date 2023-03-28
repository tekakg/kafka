package com.example.kafka.services;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "secondTopic", groupId = "adityaConsumer")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
