package com.shochat.kafkadispatch.util;

import com.shochat.kafkadispatch.message.OrderCreated;

import java.util.UUID;

public class TestEventData {
    public static OrderCreated buildOrderCreatedEvent(UUID orderId, String item) {
        return OrderCreated.builder().id(orderId).item(item).build();
    }
}
