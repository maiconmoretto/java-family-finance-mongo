package com.expense.service;

import com.expense.entity.Expense;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRestTemplateService {

    final String url = "http://localhost:8081/user";
    final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getUserById(Expense expense) {
        return this.restTemplate.getForEntity(this.url + "/" + expense.getUserId(), String.class);
    }

}
