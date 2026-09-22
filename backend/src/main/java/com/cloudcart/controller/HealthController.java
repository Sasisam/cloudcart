package com.cloudcart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "CloudCart application is running!";
    }

    @GetMapping("/health")
    public String health() {
        return "UP";
    }
}
