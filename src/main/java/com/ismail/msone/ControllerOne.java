package com.ismail.msone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/msone")
public class ControllerOne {
	
	@Value("${server.port}")
    private String port;
	
	private final WebClient webClient;
	
	public ControllerOne(WebClient.Builder weBuilder) {
		this.webClient=weBuilder
				.baseUrl("http://MICRO-SERVICE-TWO")		
				.build();
	}
	
	@GetMapping("/getOneValue")
	public String getOneValue() {
		return "Handled by MICRO-SERVICE-ONE on port " + port;
	}
	
	@GetMapping("/callMsTwo")
	public Mono<String> callMsTwo() {
		return webClient.get()
				.uri("/mstwo/getTwoValue")
				.retrieve()
				.bodyToMono(String.class);
	}

}
