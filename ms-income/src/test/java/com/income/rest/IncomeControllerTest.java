package com.income.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.income.entity.Income;
import com.income.service.IncomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class IncomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    IncomeService incomeService;

    private Income income;


    @Test
    public void testFindAll_ShouldReturn_OK() throws Exception {
      mockMvc.perform(get("/income/"))
                .andExpect(status().isOk());
    }


}
