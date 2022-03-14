package com.income.repository;

import com.income.entity.Income;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {

    public Income findByName(String name);

}