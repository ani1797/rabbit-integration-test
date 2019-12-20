package com.sdm.rabbitintegration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface RabbitInputQueues {

    String GREETING = "greeting-channel";

    @Input(GREETING)
    SubscribableChannel greeting();

}
