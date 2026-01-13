package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookDetailDto;

import java.sql.SQLException;

public interface IBookDetailDtoRepository {
    BookDetailDto findByID(int bookId) throws SQLException;
}
