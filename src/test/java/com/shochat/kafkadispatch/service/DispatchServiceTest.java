package com.shochat.kafkadispatch.service;

import com.shochat.kafkadispatch.message.OrderCreated;
import com.shochat.kafkadispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DispatchServiceTest {

    private DispatchService service;

    @BeforeEach
    public void setup() {
        service = new DispatchService();
    }

    @Test
    void process() {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(randomUUID(), randomUUID().toString());
        service.process(testEvent);
    }
}