package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.repository.AccountRepository;
import com.example.c09_project_book.repository.IAccountRepository;

import java.sql.SQLException;

public class AccountService implements IAccountService {
    IAccountRepository accountRepository= new AccountRepository();
    @Override
    public Account findAccount(String username, String password) throws SQLException {
        return accountRepository.findAccount(username, password);
    }
}
