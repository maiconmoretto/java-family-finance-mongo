package com.expense.repository;

import com.expense.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    public Expense findByName(String name);

}