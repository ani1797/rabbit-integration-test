package com.sdm.rabbitintegration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface RabbitOutputQueues {

    String GREETINGS = "greetings";

    @Output(GREETINGS)
    MessageChannel getGreetingChannel();

}
