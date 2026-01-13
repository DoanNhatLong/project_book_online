package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.repository.BookDetailDtoRepository;
import com.example.c09_project_book.repository.IBookDetailDtoRepository;

import java.sql.SQLException;

public class BookDetailDtoService implements  IBookDetailDtoService {
    IBookDetailDtoRepository bookDetailDtoRepository= new BookDetailDtoRepository();
    @Override
    public BookDetailDto findByID(int bookId) throws SQLException {
        return bookDetailDtoRepository.findByID(bookId);
    }
}
