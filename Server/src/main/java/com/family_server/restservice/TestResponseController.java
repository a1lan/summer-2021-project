package com.family_server.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/testResponse")
	public TestResponse testResponse(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new TestResponse(counter.incrementAndGet(), String.format(template, name));
	}
}