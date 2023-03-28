package com.example.kafka.controller;

import com.example.kafka.payload.User;
import com.example.kafka.services.JsonProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonKafkaController {

    private JsonProducerService jsonProducerService;

    public JsonKafkaController(JsonProducerService jsonProducerService)
    {
        this.jsonProducerService=jsonProducerService;
    }
    @PostMapping("/publish")
    public ResponseEntity<String>publish(@RequestBody User message)
    {
        jsonProducerService.sendMessage(message);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
