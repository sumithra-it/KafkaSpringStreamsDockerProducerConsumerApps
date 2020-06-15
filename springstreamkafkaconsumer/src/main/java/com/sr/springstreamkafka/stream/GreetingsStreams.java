package com.sr.springstreamkafka.stream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface GreetingsStreams {
	String INPUT = "greetings-in";
	
	@Input(INPUT)
	SubscribableChannel inboundGreetings(); //to read msg from Kafka topic
	
}
