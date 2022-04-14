package com.expense.entity;

import com.expense.enums.CategoryEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class Expense {

    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    private String userId;
    private CategoryEnum category;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String spendAt;
}