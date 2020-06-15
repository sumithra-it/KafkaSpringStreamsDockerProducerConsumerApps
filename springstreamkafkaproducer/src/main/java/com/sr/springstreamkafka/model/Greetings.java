package com.sr.springstreamkafka.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class Greetings {
	private long timestamp;
	private String message;
	private String messageId;
	private String correlationId;
}