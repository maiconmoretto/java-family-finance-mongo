package com.expense.request;

import com.expense.enums.CategoryEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class ExpenseDTO {

    private String description;
    private BigDecimal amount;
    private String userId;
    private CategoryEnum category;
    private LocalDate spendAt;
}