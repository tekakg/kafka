package com.example.kafka.controller;

import com.example.kafka.services.ProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    private ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService=producerService;
    }


    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publish(@PathVariable String message){
        System.out.println("Controller is ok");
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}