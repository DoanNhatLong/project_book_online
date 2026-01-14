package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.AccountChapter;

public interface IAccountChapterService {
    AccountChapter findByAccountId(int idAccount);

    void update(AccountChapter accountChapter);
}
