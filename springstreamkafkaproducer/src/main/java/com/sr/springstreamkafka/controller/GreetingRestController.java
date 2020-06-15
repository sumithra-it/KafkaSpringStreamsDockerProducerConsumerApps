package com.sr.springstreamkafka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sr.springstreamkafka.model.Greetings;
import com.sr.springstreamkafka.service.GreetingsChannelService;

@RestController
public class GreetingRestController {

	@Autowired
	private GreetingsChannelService greetingsChannelService;
	
	@GetMapping("/greetings")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetingsrequest(@RequestParam("message") String message) {
		Greetings greetingspojo = Greetings.builder().message(message)
													 .timestamp(System.currentTimeMillis())
													 .correlationId("corr123")
													 .messageId("001")
													 .build();
		
		greetingsChannelService.sendGreeting(greetingspojo);
	}
	
	@PostMapping("/sendkafkamessage")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void greetingInfo(@RequestBody Greetings greetingsInfo) {
		Greetings greetingspojo = Greetings.builder().message(greetingsInfo.getMessage())
													 .timestamp(System.currentTimeMillis())
													 .correlationId(greetingsInfo.getCorrelationId())
													 .messageId(greetingsInfo.getMessageId())
													 .build();
		greetingsChannelService.sendGreeting(greetingspojo);
	}
}
