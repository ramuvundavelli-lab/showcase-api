package com.ramu.showcase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/dbstatus")
    public Map<String, Object> dbStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "connected");
        status.put("database", "showcase-db");
        return status;
    }

    @GetMapping("/")
    public String home() {
        return "Showcase API is running successfully!";
    }
}
