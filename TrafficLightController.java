package com.example.trafficlight.controller;

import com.example.trafficlight.model.LightColor;
import com.example.trafficlight.model.TrafficLight;
import com.example.trafficlight.service.TrafficLightService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/traffic")
public class TrafficLightController {

    private final TrafficLightService service;

    public TrafficLightController(TrafficLightService service) {
        this.service = service;
    }

    @PostMapping("/change/{direction}/{color}")
    public String changeLight(@PathVariable String direction, @PathVariable String color) {
        service.changeLight(direction.toUpperCase(), LightColor.valueOf(color.toUpperCase()));
        return "Light changed for " + direction;
    }

    @GetMapping("/state")
    public Map<String, TrafficLight> getState() {
        return service.getCurrentState();
    }

    @PostMapping("/pause")
    public String pause() {
        service.pause();
        return "System paused";
    }

    @PostMapping("/resume")
    public String resume() {
        service.resume();
        return "System resumed";
    }
}
