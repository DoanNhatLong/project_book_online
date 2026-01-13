package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookDetailDto;

import java.sql.SQLException;

public interface IBookDetailDtoService {
    BookDetailDto findByID(int bookId) throws SQLException;
}
