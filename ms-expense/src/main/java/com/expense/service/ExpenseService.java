package com.expense.service;

import com.expense.entity.Expense;
import com.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    private UserRestTemplateService userRestTemplate;


    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense save(Expense expense) throws Exception {
        ResponseEntity userById = this.userRestTemplate.getUserById(expense);
        if (userById.getStatusCode().value() != HttpStatus.OK.value()) {
            throw new Exception("User with id = " + expense.getUserId() + " does not exist.");
        }

        return expenseRepository.save(expense);
    }

    public Page<Expense> findWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Expense> expenses = expenseRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return expenses;
    }

    public Page<Expense> findByIdUserWithPaginationAndSorting(int offset, int pageSize, String field, String idUser) {
        Page<Expense> expenses = expenseRepository.findByUserId(idUser, PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return expenses;
    }
}
