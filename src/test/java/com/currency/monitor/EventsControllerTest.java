package com.currency.monitor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class EventsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void deleteEvent()throws Exception {
        RequestBuilder request = get("/events/delete/10000000");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(302, result.getResponse().getStatus());
    }

}