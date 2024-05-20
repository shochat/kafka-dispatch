package com.shochat.kafkadispatch.service;

import com.shochat.kafkadispatch.message.OrderCreated;
import org.springframework.stereotype.Service;

@Service
public class DispatchService {
    public void process(OrderCreated payload) {
        // no opt
    }
}
