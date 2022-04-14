package com.expense.repository;

import com.expense.entity.Expense;
import com.expense.enums.CategoryEnum;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
        this.expense.setSpendAt("2020-01-01");
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
        Page<Expense> pageableByUserId = expenseRepository.findByUserId(this.expense.getUserId(), null);
        Assert.assertNotNull(pageableByUserId);
        Assert.assertEquals(pageableByUserId.getContent().get(0).getUserId(), this.expense.getUserId());
    }

    @Test
    public void testFindAll_ShouldReturnExpense() {
        List<Expense> expense = expenseRepository.findAll();
        Assert.assertNotNull(expense);
    }
}
