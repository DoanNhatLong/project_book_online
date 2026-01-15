package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDetailDtoRepository {
    BookDetailDto findByID(int bookId) throws SQLException;
    List<BookDetailDto> findAll();
    boolean add(Book book);
    boolean edit(int id,Book book);
    boolean deleteById(int id);
    Book findById(int bookId);
    boolean addContent(int id,String pdfPath);
}
