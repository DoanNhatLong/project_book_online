package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {
    Account findAccount(String username, String password) throws SQLException;
    List<Account> findAll();
    List<Account> searchByUsername(String username);
    List<Account> updateStatusAccount(String username);

}
