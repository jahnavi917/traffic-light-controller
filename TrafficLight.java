package com.example.trafficlight.model;

import java.time.LocalDateTime;

public class TrafficLight {
    private String direction;
    private LightColor color;
    private LocalDateTime lastChanged;

    public TrafficLight(String direction, LightColor color) {
        this.direction = direction;
        this.color = color;
        this.lastChanged = LocalDateTime.now();
    }

    public String getDirection() { return direction; }
    public LightColor getColor() { return color; }
    public LocalDateTime getLastChanged() { return lastChanged; }

    public void setColor(LightColor color) {
        this.color = color;
        this.lastChanged = LocalDateTime.now();
    }
}
