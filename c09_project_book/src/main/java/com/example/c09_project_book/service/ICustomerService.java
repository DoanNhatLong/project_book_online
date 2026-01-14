package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Customer;

public interface ICustomerService {
    Customer findByAccountId(int idAccount);
}
