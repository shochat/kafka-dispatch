package com.shochat.kafkadispatch.handler;

import com.shochat.kafkadispatch.message.OrderCreated;
import com.shochat.kafkadispatch.service.DispatchService;
import com.shochat.kafkadispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderCreatedHandlerTest {
    private OrderCreatedHandler handler;
    private DispatchService dispatchServiceMock;

    @BeforeEach
    public void setup() {
        dispatchServiceMock = mock(DispatchService.class);
        handler = new OrderCreatedHandler(dispatchServiceMock);
    }

    @Test
    void listen() {
        OrderCreated testEvent = TestEventData.buildOrderCreatedEvent(UUID.randomUUID(), UUID.randomUUID().toString());
        handler.listen(testEvent);
        verify(dispatchServiceMock, times(1)).process(testEvent);
    }
}