package com.example.kafka.services;

import com.example.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumerService.class);

    @KafkaListener(topics = "firstJsonTopic" ,groupId = "adityaJsonConsumer")
    public void consume(User message)
    {
        LOGGER.info(String.format("Message received -> %s",message));
    }

}
