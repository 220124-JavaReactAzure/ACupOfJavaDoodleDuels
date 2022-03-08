package com.revature.JavaDoodleDuels;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.revature"})
public class JavaDoodleDuelsApplication {
	
	private final static Logger  log = LogManager.getFormatterLogger();
			
	public static void main(String[] args) {
		
		log.info("Application starting...");
		SpringApplication.run(JavaDoodleDuelsApplication.class, args);
	}

}
