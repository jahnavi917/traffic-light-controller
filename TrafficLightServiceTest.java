package com.example.trafficlight;

import com.example.trafficlight.model.LightColor;
import com.example.trafficlight.service.TrafficLightService;
import com.example.trafficlight.exception.ConflictException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightServiceTest {

    @Test
    public void testGreenConflict() {
        TrafficLightService service = new TrafficLightService();
        service.changeLight("NORTH", LightColor.GREEN);
        assertThrows(ConflictException.class, () -> {
            service.changeLight("EAST", LightColor.GREEN);
        });
    }

    @Test
    public void testPauseResume() {
        TrafficLightService service = new TrafficLightService();
        service.pause();
        service.changeLight("NORTH", LightColor.GREEN); // should not change
        assertEquals(LightColor.RED, service.getCurrentState().get("NORTH").getColor());

        service.resume();
        service.changeLight("NORTH", LightColor.GREEN);
        assertEquals(LightColor.GREEN, service.getCurrentState().get("NORTH").getColor());
    }
}
