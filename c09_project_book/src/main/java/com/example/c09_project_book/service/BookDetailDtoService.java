package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;
import com.example.c09_project_book.repository.BookDetailDtoRepository;
import com.example.c09_project_book.repository.IBookDetailDtoRepository;

import java.sql.SQLException;
import java.util.List;

public class BookDetailDtoService implements  IBookDetailDtoService {
    IBookDetailDtoRepository bookDetailDtoRepository= new BookDetailDtoRepository();
    @Override
    public BookDetailDto findByID(int bookId) throws SQLException {
        return bookDetailDtoRepository.findByID(bookId);
    }

    @Override
    public List<BookDetailDto> findAll() {
        return bookDetailDtoRepository.findAll();
    }

    @Override
    public boolean add(Book book) {
        return bookDetailDtoRepository.add(book);
    }

    @Override
    public boolean edit(int id, Book book) {
        return bookDetailDtoRepository.edit(id,book);
    }

    @Override
    public boolean deleteById(int id) {
        return bookDetailDtoRepository.deleteById(id);
    }

    @Override
    public Book findById(int bookId) {
        return bookDetailDtoRepository.findById(bookId);
    }

    @Override
    public boolean addContent(int id, String pdfUrl) {
        return bookDetailDtoRepository.addContent(id, pdfUrl);
    }
    public List<BookDetailDto> searchByMulti(String author, String bookName, Double price) {
        return bookDetailDtoRepository.searchByMulti(author,bookName,price);
    }
}
