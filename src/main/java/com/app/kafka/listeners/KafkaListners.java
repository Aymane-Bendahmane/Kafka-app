package com.app.kafka.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListners {
    @KafkaListener(topics = "my-topic",groupId = "groupId")
    void listener(String message) {
        System.out.println("📢 Listener received data : "+message + " 📢");
    }
}
