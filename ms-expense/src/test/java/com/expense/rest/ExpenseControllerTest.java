package com.expense.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.expense.entity.Expense;
import com.expense.enums.CategoryEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.UUID;


@SpringBootTest
@AutoConfigureMockMvc
public class ExpenseControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    MockService mockService;

    @Test
    public void testFindAll() throws Exception {
        mockMvc.perform(get("/expense"))
                .andExpect(status().isOk());
    }


/*    @Test
    public void testSave() throws Exception {
        Expense expense = new Expense();
        expense.setAmount(BigDecimal.valueOf(500.52));
        expense.setName(UUID.randomUUID().toString());
        expense.setUserId(UUID.randomUUID().toString());
        expense.setCategory(CategoryEnum.PARTY);

        RestTemplate restTemplate = new RestTemplate();

        Mockito.when(this.mockService.userRestTemplateService.getUserById(Mockito.any())).thenReturn(new ResponseEntity());

        mockMvc.perform(post("/expense")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(expense)))
                .andExpect(status().isOk());
    }*/





}
