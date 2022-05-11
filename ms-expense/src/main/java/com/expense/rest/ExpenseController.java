package com.expense.rest;

import com.expense.entity.Expense;
import com.expense.request.ExpenseDTO;
import com.expense.service.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
@Api(value = "testes")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @ApiOperation(value = "Save a new expense")
    @PostMapping
    public ResponseEntity<Expense> save(@RequestBody ExpenseDTO expenseDTO) throws Exception {
        return new ResponseEntity<Expense>(expenseService.save(expenseDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a new expense")
    @PutMapping
    public ResponseEntity<Expense> update(Expense expense) throws Exception {
        return new ResponseEntity<Expense>(expenseService.update(expense), HttpStatus.OK);
    }

    @ApiOperation(value = "Find all expenses")
    @GetMapping
    public List<Expense> findAll() {
        return expenseService.findAll();
    }

    @ApiOperation(value = "Find a expense by id")
    @GetMapping("/{id}")
    public Optional<Expense> findById(@PathVariable String id) {
        return expenseService.findById(id);
    }

    @ApiOperation(value = "Find all expenses with pagination and sort")
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public Page<Expense> findWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Expense> expensesPagination = expenseService.findWithPaginationAndSorting(offset, pageSize, field);
        return expensesPagination;
    }

    @ApiOperation(value = "Find all expenses by user id with pagination and sort")
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}/{userId}")
    public Page<Expense> findByIdUserWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field, @PathVariable String userId) {
        Page<Expense> expensesPagination = expenseService.findByIdUserWithPaginationAndSorting(offset, pageSize, field, userId);
        return expensesPagination;
    }

    @ApiOperation(value = "Delete a expense")
    @DeleteMapping("/{id}")
    public void  delete(@PathVariable ("id") String id) {
        expenseService.deleteById(id);
    }
}