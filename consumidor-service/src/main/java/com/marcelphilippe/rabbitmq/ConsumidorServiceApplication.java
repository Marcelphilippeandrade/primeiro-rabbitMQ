package com.marcelphilippe.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ConsumidorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidorServiceApplication.class, args);
	}
}
