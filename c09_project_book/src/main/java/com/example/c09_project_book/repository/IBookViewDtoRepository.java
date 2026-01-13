package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookViewDto;

import java.util.List;

public interface IBookViewDtoRepository {
    List<BookViewDto> findByTag(int idTag);
}
