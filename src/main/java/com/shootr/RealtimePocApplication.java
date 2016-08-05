package com.shootr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class RealtimePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealtimePocApplication.class, args);
	}
}
