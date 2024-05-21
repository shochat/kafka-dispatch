package com.shochat.kafkadispatch.controller;

import com.shochat.kafkadispatch.message.OrderCreated;
import com.shochat.kafkadispatch.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class KafkaHttpRestProxyController {
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaHttpRestProxyController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/order")
    public void sendMessageToKafkaTopic(@RequestBody OrderCreated payload) {
        kafkaProducerService.sendMessage(payload);
    }
}
