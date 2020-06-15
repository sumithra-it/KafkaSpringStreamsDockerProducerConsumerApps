package com.sr.springstreamkafka.service;

import org.springframework.stereotype.Component;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.sr.springstreamkafka.stream.GreetingsStreams;
import org.springframework.messaging.handler.annotation.Payload;
import com.sr.springstreamkafka.model.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;

@Slf4j
@Component
public class GreetingsTopicListener {
	
	@StreamListener(GreetingsStreams.INPUT)
	public void handleGreetingsMsg(@Payload Greetings greetingspojo) {
		log.info("Received message: {} with correlationid and messageId: ",
				greetingspojo);
	}
	
}
