package com.sr.springstreamkafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.sr.springstreamkafka.stream.GreetingsStreams;
import com.sr.springstreamkafka.model.Greetings;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;


@Service
@Slf4j
public class GreetingsChannelService {
private final GreetingsStreams greetingsStreams;
	
public GreetingsChannelService(GreetingsStreams greetingsStreams) {
	this.greetingsStreams = greetingsStreams;
}

public void sendGreeting(final Greetings greetingspojo) {
	log.info("Sending message {} to kafka channel", greetingspojo);
	MessageChannel messageChannel = greetingsStreams.outboundGreetings();
	messageChannel.send(
			MessageBuilder.withPayload(greetingspojo).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
			.build());
}

}
