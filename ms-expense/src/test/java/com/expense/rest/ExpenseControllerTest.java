package com.expense.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.expense.entity.Expense;
import com.expense.entity.User;
import com.expense.enums.CategoryEnum;
import com.expense.request.ExpenseDTO;
import com.expense.service.ExpenseService;
import com.expense.service.UserRestTemplateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
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

    @Autowired
    ExpenseService expenseService;

    @Autowired
    UserRestTemplateService userRestTemplateService;

    @Test
    public void testFindAll_ShouldReturn_OK() throws Exception {
        mockMvc.perform(get("/expense"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByIdUserWithPaginationAndSorting_ShouldReturn_OK() throws Exception {
        String url = "/expense/paginationAndSort/1/2/id/622213a205cbe91ac023f189";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindWithPaginationAndSorting_ShouldReturn_OK() throws Exception {
        String url = "/expense/paginationAndSort/1/2/id";
        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }
/*    @Test
    public void testSave() throws Exception {
        Expense expense = new Expense();
        expense.setAmount(BigDecimal.valueOf(500.52));
        expense.setDescription(UUID.randomUUID().toString());
        expense.setUserId(UUID.randomUUID().toString());
        expense.setCategory(CategoryEnum.PARTY);

        ExpenseDTO expenseDTO = new ExpenseDTO();
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);

        Mockito.when(this.expenseService.save(expenseDTO)).thenReturn(expense);

        Mockito.when(this.userRestTemplateService.getUserById(Mockito.any())).thenReturn(responseEntity);

        mockMvc.perform(post("/expense")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(expenseDTO)))
                .andExpect(status().isOk());
    }*/





}
