package com.example.trafficlight.service;

import com.example.trafficlight.exception.ConflictException;
import com.example.trafficlight.model.LightColor;
import com.example.trafficlight.model.TrafficLight;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TrafficLightService {
    private final Map<String, TrafficLight> lights = new ConcurrentHashMap<>();
    private volatile boolean paused = false;

    public TrafficLightService() {
        lights.put("NORTH", new TrafficLight("NORTH", LightColor.RED));
        lights.put("SOUTH", new TrafficLight("SOUTH", LightColor.RED));
        lights.put("EAST", new TrafficLight("EAST", LightColor.RED));
        lights.put("WEST", new TrafficLight("WEST", LightColor.RED));
    }

    public synchronized void changeLight(String direction, LightColor color) {
        if (paused) return;

        if (color == LightColor.GREEN) {
            for (TrafficLight tl : lights.values()) {
                if (!tl.getDirection().equals(direction) && tl.getColor() == LightColor.GREEN) {
                    throw new ConflictException("Conflict: Another direction is already GREEN");
                }
            }
        }
        lights.get(direction).setColor(color);
    }

    public Map<String, TrafficLight> getCurrentState() {
        return lights;
    }

    public void pause() { paused = true; }
    public void resume() { paused = false; }
}
