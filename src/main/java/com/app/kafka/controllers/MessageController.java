package com.app.kafka.controllers;

import com.app.kafka.records.MessageRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody MessageRecord request) {
        kafkaTemplate.send("my-topic", request.message());
        return request.message();
    }
}
