package com.revature.JavaDoodleDuels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.revature"})
public class JavaDoodleDuelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDoodleDuelsApplication.class, args);
	}

}
