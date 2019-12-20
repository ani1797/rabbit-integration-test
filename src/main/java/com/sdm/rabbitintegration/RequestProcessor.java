package com.sdm.rabbitintegration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestProcessor {
    public void process(Message message) {
        log.info("Processing the request: {}", message);
    }
}
