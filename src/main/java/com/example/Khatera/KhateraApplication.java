package com.example.Khatera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = {"com.example"})
public class KhateraApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhateraApplication.class, args);
	}

}
