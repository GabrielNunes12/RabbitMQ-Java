package com.org.SpringRabbitMQ.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.RoutingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.org.SpringRabbitMQ.constants.Constants.*;

@Configuration
public class RabbitMQConfig {
    //who implements Exchages (FanoutExchange, DirectExchange, HeadersExchange and so on)



    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false, false, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(ROUTING_KEY);
    }
}
