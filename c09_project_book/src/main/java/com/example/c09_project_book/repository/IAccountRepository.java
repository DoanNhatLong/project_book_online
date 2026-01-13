package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Account;

import java.sql.SQLException;

public interface IAccountRepository {
    Account findAccount(String username, String password) throws SQLException;
}
