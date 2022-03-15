package com.expense.rest;

import com.expense.entity.Expense;
import com.expense.service.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
@Api(value = "testes")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @ApiOperation(value = "Save a new expense")
    @PostMapping
    public ResponseEntity<Expense> save(@RequestBody Expense expense) throws Exception {
        return new ResponseEntity<Expense>(expenseService.save(expense), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> findAllPaginated() {
        return expenseService.findAll();
    }


    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public Page<Expense> findWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Expense> expensesPagination = expenseService.findWithPaginationAndSorting(offset, pageSize, field);
        return expensesPagination;
    }


    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}/{userId}")
    public Page<Expense> findByIdUserWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field, @PathVariable String userId) {
        Page<Expense> expensesPagination = expenseService.findByIdUserWithPaginationAndSorting(offset, pageSize, field, userId);
        return expensesPagination;
    }
}