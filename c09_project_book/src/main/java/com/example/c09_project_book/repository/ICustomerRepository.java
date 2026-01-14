package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Customer;

public interface ICustomerRepository {
    Customer findByAccountId(int idAccount);
}
