package com.example.kafka.services;

import com.example.kafka.payload.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducerService.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducerService(KafkaTemplate<String,User> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }
    public void sendMessage(User message){
        LOGGER.info(String.format("Message sent %s", message.toString()));
        Message<User>message1= MessageBuilder.withPayload(message).
                setHeader(KafkaHeaders.TOPIC, "firstJsonTopic").build();
        kafkaTemplate.send(message1);
    }
}
