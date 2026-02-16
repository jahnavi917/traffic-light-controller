package com.example.trafficlight;

import com.example.trafficlight.service.TrafficLightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TrafficLightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testChangeLightEndpoint() throws Exception {
        mockMvc.perform(post("/api/traffic/change/NORTH/GREEN"))
                .andExpect(status().isOk());
    }
}
