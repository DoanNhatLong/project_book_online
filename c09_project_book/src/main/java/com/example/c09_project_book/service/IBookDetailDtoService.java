package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDetailDtoService {
    BookDetailDto findByID(int bookId) throws SQLException;
    List<BookDetailDto> findAll();
    boolean add(Book book);
    boolean edit(int id,Book book);
    boolean deleteById(int id);
/* long code */
    List<BookDetailDto> searchByMulti(String author, String bookName, Double price);
}
