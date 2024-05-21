package com.shochat.kafkadispatch.service;

import com.shochat.kafkadispatch.message.OrderCreated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, OrderCreated> kafkaTemplate;
    private final String topicName;

    public KafkaProducerService(KafkaTemplate<String, OrderCreated> kafkaTemplate,
                                @Value("${topic.name}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    public void sendMessage(OrderCreated message) {
        kafkaTemplate.send(topicName, message);
    }
}