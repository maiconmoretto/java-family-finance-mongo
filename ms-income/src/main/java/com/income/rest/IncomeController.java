package com.income.rest;

import com.income.entity.Income;
import com.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeController {

    @Autowired
    IncomeService IncomeService;

    @GetMapping("/income")
    public List<Income> findAll() {
        return IncomeService.findAll();
    }

    @PostMapping("/income")
    public Income save(@RequestBody Income Income) throws Exception {
        return IncomeService.save(Income);
    }
}