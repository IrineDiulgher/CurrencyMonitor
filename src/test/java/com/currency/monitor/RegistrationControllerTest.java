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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void index()throws Exception {
        RequestBuilder request = get("/registration");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("Registration"));
    }

    @Test
    void addUser_wrongMethod() throws Exception {
        RequestBuilder request = get("/registration/add");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(405, result.getResponse().getStatus());
    }

    @Test
    void addUser() throws Exception {
        RequestBuilder request = post("/registration/add");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals(302, result.getResponse().getStatus());
    }

}