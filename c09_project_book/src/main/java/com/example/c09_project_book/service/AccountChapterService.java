package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.AccountChapter;
import com.example.c09_project_book.repository.AccountChapterRepository;
import com.example.c09_project_book.repository.IAccountChapterRepository;

import java.sql.SQLException;

public class AccountChapterService implements IAccountChapterService {
    IAccountChapterRepository accountChapterRepository=new AccountChapterRepository();
    @Override
    public AccountChapter findByAccountId(int idAccount) {
        return accountChapterRepository.findByAccountId(idAccount);
    }

    @Override
    public void update(AccountChapter accountChapter) throws SQLException {
        accountChapterRepository.update(accountChapter);
    }
}
