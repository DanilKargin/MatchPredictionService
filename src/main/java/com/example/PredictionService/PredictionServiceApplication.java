package com.example.PredictionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.example.PredictionService.repository")
@PropertySource("classpath:application-dev.yml")
public class PredictionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PredictionServiceApplication.class, args);
	}
}
