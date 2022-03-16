package com.expense.repository;

import com.expense.entity.Expense;
import com.expense.enums.CategoryEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@DataMongoTest
public class ExpenseRepositoryTest {

    @Autowired
    ExpenseRepository expenseRepository;

    private Expense expense;


    @Before
    public void setUp() {
        this.expense = new Expense();
        this.expense.setDescription("test description");
        this.expense.setSpendAt(LocalDate.now());
        this.expense.setUserId("622213a205cbe91ac023f180");
        this.expense.setAmount(BigDecimal.valueOf(333.33));
        this.expense.setCategory(CategoryEnum.SHOP);
        Expense save = expenseRepository.save(this.expense);
        this.expense.setId(save.getId());
    }

    @After
    public void cleanDatabase() {
        expenseRepository.deleteById(this.expense.getId());
    }

    @Test
    public void testFindByUserId_ShouldReturnExpense() {
        String userId = "622213a205cbe91ac023f180";
        Page<Expense> pageableByUserId = expenseRepository.findByUserId(userId, null);
        Assert.assertNotNull(pageableByUserId);
        Assert.assertEquals(pageableByUserId.getContent().get(0).getUserId(), userId);
    }
}
