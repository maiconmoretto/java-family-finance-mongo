package com.income.rest;

import com.income.entity.Income;
import com.income.service.IncomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "income")
public class IncomeController {

    @Autowired
    IncomeService incomeService;


    @ApiOperation(value = "List all incomes")
    @GetMapping("/income")
    public List<Income> findAll() {
        return incomeService.findAll();
    }

    @ApiOperation(value = "Save a income")
    @PostMapping("/income")
    public Income save(@RequestBody Income Income) throws Exception {
        return incomeService.save(Income);
    }
}