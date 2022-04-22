package com.expense.service;

import com.expense.entity.Expense;
import com.expense.repository.ExpenseRepository;
import com.expense.request.ExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    private UserRestTemplateService userRestTemplate;


    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense save(ExpenseDTO expenseDTO) throws Exception {
        Expense expense = new Expense();
        expense.setCategory(expenseDTO.getCategory());
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setUserId(expenseDTO.getUserId());
        expense.setSpendAt(expenseDTO.getSpendAt());

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

    public Page<Expense> findByIdUserWithPaginationAndSorting(int offset, int pageSize, String field, String userId) {
        Page<Expense> expenses = expenseRepository.findByUserId(userId, PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return expenses;
    }

    public Optional<Expense> findById(String id) {
        return expenseRepository.findById(id);
    }

    public Expense update(Expense expenseUpdate) {
        Expense expense = new Expense();
        expense.setId(expenseUpdate.getId());
        expense.setAmount(expenseUpdate.getAmount());
        expense.setCategory(expenseUpdate.getCategory());
        expense.setSpendAt(expenseUpdate.getSpendAt());
        expense.setDescription(expenseUpdate.getDescription());
        expense.setUserId(expenseUpdate.getUserId());

       return  expenseRepository.save(expense);
    }
}
