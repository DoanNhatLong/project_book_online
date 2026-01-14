package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.AccountChapter;

import java.sql.SQLException;

public interface IAccountChapterRepository {
    AccountChapter findByAccountId(int idAccount);
    void update(AccountChapter accountChapter) throws SQLException;
}
