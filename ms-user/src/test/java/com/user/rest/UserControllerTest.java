package com.user.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.entity.User;
import com.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

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


}
