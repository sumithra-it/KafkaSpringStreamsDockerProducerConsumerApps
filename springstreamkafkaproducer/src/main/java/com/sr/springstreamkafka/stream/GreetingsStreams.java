package com.sr.springstreamkafka.stream;

import org.springframework.cloud.stream.annotation.Output;

import org.springframework.messaging.MessageChannel;

public interface GreetingsStreams {
	String OUTPUT = "greetings-out";
	
	@Output(OUTPUT)
	MessageChannel outboundGreetings();
	//to write meesages to a Kafka topic
}
