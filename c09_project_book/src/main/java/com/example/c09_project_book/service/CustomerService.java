package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Customer;
import com.example.c09_project_book.repository.CustomerRepository;
import com.example.c09_project_book.repository.ICustomerRepository;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository=new CustomerRepository();
    @Override
    public Customer findByAccountId(int idAccount) {
        return customerRepository.findByAccountId(idAccount);
    }
}
