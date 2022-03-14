package com.income.service;

import com.income.entity.Income;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserRestTemplateService {

    final String url = "http://localhost:8081/user";
    final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity getUserById(Income income) {
        return this.restTemplate.getForEntity(this.url + "/" + income.getUserId(), String.class);
    }

}
