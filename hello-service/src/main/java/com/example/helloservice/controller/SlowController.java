package com.example.helloservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class SlowController {


    @GetMapping("/hello/e")
    public Map<String, String> hello() {
        return response();
    }

    private Map<String, String> response() {
        Map<String, String> result = new LinkedHashMap<>();
        result.put("message", "test slow sql");
        result.put("pod", System.getenv().getOrDefault("HOSTNAME", "local"));
        result.put("time", Instant.now().toString());
        return result;
    }
}
