package com.income.service;

import com.income.entity.Income;
import com.income.repository.IncomeRepository;
import com.income.service.UserRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository userRepository;

    @Autowired
    private UserRestTemplateService userRestTemplate;

    public List<Income> findAll() {
        return userRepository.findAll();
    }

    public Income save(Income income) throws Exception {
        ResponseEntity userById = this.userRestTemplate.getUserById(income);
        if (userById == null) {
            throw new Exception("User with id = " + income.getUserId() +" does not exist.");
        }

        return userRepository.save(income);
    }
}
