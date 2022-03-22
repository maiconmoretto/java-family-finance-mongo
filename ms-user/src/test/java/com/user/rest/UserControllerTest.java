package com.user.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.User;
import com.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    UserService expenseService;

    private User user;


    @Test
    public void testFindAll_ShouldReturn_OK() throws Exception {
        mockMvc.perform(get("/user/"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate_ShouldReturn_OK() throws Exception {
        URI uri = new URI("/user/");
        String user = "{\"name\":\"user name test  \"}";
        ResultActions resultActions = mockMvc.perform(
                        MockMvcRequestBuilders.post(uri)
                                .content(user)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
