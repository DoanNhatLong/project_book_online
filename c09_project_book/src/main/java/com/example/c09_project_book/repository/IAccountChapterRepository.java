package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.AccountChapter;

public interface IAccountChapterRepository {
    AccountChapter findByAccountId(int idAccount);
}
