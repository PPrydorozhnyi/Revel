package com.meetup.meetup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Locale;

@SpringBootApplication
@EnableScheduling
public class RevelApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(RevelApplication.class);

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		SpringApplication.run(RevelApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RevelApplication.class);
	}
}
