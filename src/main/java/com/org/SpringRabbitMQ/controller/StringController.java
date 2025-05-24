package com.org.SpringRabbitMQ.controller;

import com.org.SpringRabbitMQ.consumer.StringConsumer;
import com.org.SpringRabbitMQ.services.StringServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produces")
public class StringController {
    private final StringServices stringServices;
    private final StringConsumer stringConsumer;
    public StringController(StringServices stringServices, StringConsumer stringConsumer) {
        this.stringServices = stringServices;
        this.stringConsumer = stringConsumer;
    }
    @PostMapping
    public ResponseEntity<?> postMessage(@RequestBody String message) {
        return ResponseEntity.ok(stringServices.produceMessage(message));
    }

    @GetMapping
    public ResponseEntity<List<String>> allQueries() {
        return ResponseEntity.ok(stringConsumer.allQueries());
    }
}
