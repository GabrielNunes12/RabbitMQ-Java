package com.org.SpringRabbitMQ.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.org.SpringRabbitMQ.constants.Constants.EXCHANGE_MARKETPLACE;
import static com.org.SpringRabbitMQ.constants.Constants.ROUTING_KEY;

@Service
public class StringServices {
    private final RabbitTemplate rabbitTemplate;

    public StringServices(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String produceMessage(String message) {
        System.out.println("Received message " + message);
        rabbitTemplate.convertAndSend(EXCHANGE_MARKETPLACE, ROUTING_KEY, message);
        return "Your message has been queued";
    }
}
