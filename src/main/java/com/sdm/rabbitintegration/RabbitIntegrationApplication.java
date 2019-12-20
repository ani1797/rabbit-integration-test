package com.sdm.rabbitintegration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class RabbitIntegrationApplication {

	final RequestProcessor processor;
	final RabbitOutputQueues queues;

	public static void main(String[] args) {
		SpringApplication.run(RabbitIntegrationApplication.class, args);
	}

	@StreamListener(target = RabbitInputQueues.GREETING)
	public void listenToGreeting(Message message) {
		log.info("Message Received: {}", message);
		processor.process(message);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
				log.info("Started the message queue hopefully!");
				for (int i = 0; i < 5; i++) {
					log.info("Sending Messages");
					queues.getGreetingChannel().send(MessageBuilder.withPayload("Message Number: " + i).build());
				}
				log.info("Sent all message!");
		};
	}

}



