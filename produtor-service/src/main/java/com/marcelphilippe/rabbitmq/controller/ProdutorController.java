package com.marcelphilippe.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marcelphilippe.rabbitmq.model.User;
import com.marcelphilippe.rabbitmq.service.RabbitMqSender;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProdutorController {

	private RabbitMqSender rabbitMqSender;
	
	@Value("${app.message}")
    private String message;

	@Autowired
	public ProdutorController(RabbitMqSender rabbitMqSender) {
		this.rabbitMqSender = rabbitMqSender;
	}
	
	@PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
        rabbitMqSender.send(user);
        return message;
    }
}
