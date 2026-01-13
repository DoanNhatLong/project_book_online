package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;

import java.sql.SQLException;

public interface IAccountService {
    Account findAccount(String username, String password) throws SQLException;
}
