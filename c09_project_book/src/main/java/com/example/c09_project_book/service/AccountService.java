package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.repository.AccountRepository;
import com.example.c09_project_book.repository.IAccountRepository;

import java.sql.SQLException;
import java.util.List;

public class AccountService implements IAccountService {
    private IAccountRepository accountRepository= new AccountRepository();
    @Override
    public Account findAccount(String username, String password) throws SQLException {
        return accountRepository.findAccount(username, password);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> searchByUsername(String username) {
        return List.of();
    }

    @Override
    public boolean updateStatusAccount(String username,boolean status) {
        Account account = accountRepository.findAccountByUsername(username);
        if (account!=null){
          return accountRepository.updateStatusAccount(account.getId(),status);
        }
        return false;
    }
}
