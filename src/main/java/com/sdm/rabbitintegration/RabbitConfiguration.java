package com.sdm.rabbitintegration;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({
        RabbitOutputQueues.class,
        RabbitInputQueues.class
})
public class RabbitConfiguration {

}
