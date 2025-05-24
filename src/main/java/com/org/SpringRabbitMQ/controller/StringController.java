package com.org.SpringRabbitMQ.controller;

import com.org.SpringRabbitMQ.services.StringServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produces")
public class StringController {
    private final StringServices stringServices;
    public StringController(StringServices stringServices) {
        this.stringServices = stringServices;
    }
    @PostMapping
    public ResponseEntity<?> postMessage(@RequestBody String message) {
        return ResponseEntity.ok(stringServices.produceMessage(message));
    }
}
