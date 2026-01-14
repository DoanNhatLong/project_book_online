package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    Account findAccount(String username, String password) throws SQLException;
    List<Account> findAll();
    List<Account> searchByUsername(String username);
    boolean updateStatusAccount(String username,boolean status);
}
