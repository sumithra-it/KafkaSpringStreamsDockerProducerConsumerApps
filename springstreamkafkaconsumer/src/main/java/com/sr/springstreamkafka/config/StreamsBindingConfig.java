package com.sr.springstreamkafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import com.sr.springstreamkafka.stream.GreetingsStreams;
import org.springframework.context.annotation.Configuration;

//Enables the binding of targets annotated with Input and Output to a broker.
@Configuration
@EnableBinding(GreetingsStreams.class)
public class StreamsBindingConfig {

}
