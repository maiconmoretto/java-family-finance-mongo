package com.expense.rest;

import com.expense.service.UserRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MockService {

    @Autowired
    UserRestTemplateService userRestTemplateService;
}
