package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookViewDto;
import com.example.c09_project_book.repository.BookViewDtoRepository;
import com.example.c09_project_book.repository.IBookViewDtoRepository;

import java.util.List;

public class BookViewDtoService implements  IBookViewDtoService {
    IBookViewDtoRepository bookViewDtoRepository = new BookViewDtoRepository();
    @Override
    public List<BookViewDto> findByTag(int idTag) {
        return bookViewDtoRepository.findByTag(idTag);
    }
}
