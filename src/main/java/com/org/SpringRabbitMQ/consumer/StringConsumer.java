package com.org.SpringRabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Vector;

import static com.org.SpringRabbitMQ.constants.Constants.QUEUE_NAME;

@Component
public class StringConsumer {
    private final RabbitTemplate rabbitTemplate;
    private List<String> addedOptions = new Vector<>();

    public StringConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received message through listeners: " + message);
        if(message.contains("OS")) {
            addedOptions.add(message);
        }
    }
    public List<String> allQueries() {
        return this.addedOptions;
    }
}
