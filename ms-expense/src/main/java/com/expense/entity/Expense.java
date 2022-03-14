package com.expense.entity;

import com.expense.enums.CategoryEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Expense {

    @Id
    private String id;
    private String name;
    private BigDecimal amount;
    private String userId;
    private CategoryEnum category;


}