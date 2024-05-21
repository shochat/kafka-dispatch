package com.shochat.kafkadispatch.handler;

import com.shochat.kafkadispatch.message.OrderCreated;
import com.shochat.kafkadispatch.service.DispatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedHandler {

    private final DispatchService dispatchService;

    @KafkaListener(
            id = "orderConsumerClient",
            topics = "shochat.topic",
            groupId = "dispatch.shochat.topic.consumer",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(OrderCreated payload) {
        log.info("Received message with payload: {}", payload);
        dispatchService.process(payload);
    }
}
