package com.currency.monitor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AlarmsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void addAlarms() throws Exception {
        RequestBuilder request = post("/alarms/add");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    void deleteAlarms() throws Exception {
        RequestBuilder request = post("/alarms/delete");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(302, result.getResponse().getStatus());
    }
}