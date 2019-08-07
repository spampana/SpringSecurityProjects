package com.helpezee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootBasicAuthentication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicAuthentication.class, args);
	}
}
