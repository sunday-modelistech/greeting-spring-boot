package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
        private final Logger logger = LoggerFactory.getLogger(this.getClass().getPackage().getName());
	private final AtomicLong counter = new AtomicLong();
        
        @Autowired
        private MessageRepository messageRepository;

        @Value("${app.default.language}")
        private String appLanguage;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
                logger.info("try to find message by language ");
                Message message = messageRepository.findByLanguage(appLanguage);
                if (message.getIdMessage() != null) {
                    logger.info("successful find message by language ");
                    return new Greeting(counter.incrementAndGet(), message.getMessage());
                }
                logger.info("unsuccessful find message by language ");
                return new Greeting(counter.incrementAndGet(), "");
	}
}
