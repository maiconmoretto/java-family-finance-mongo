package com.expense.repository;

import com.expense.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface ExpenseRepository extends MongoRepository<Expense, String> {

    Page<Expense> findByUserId(String userId, Pageable pageable);
}