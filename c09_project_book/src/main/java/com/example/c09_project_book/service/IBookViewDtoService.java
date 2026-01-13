package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BookViewDto;
import com.example.c09_project_book.repository.BookViewDtoRepository;
import com.example.c09_project_book.repository.IBookViewDtoRepository;

import java.util.List;

public interface IBookViewDtoService {


    List<BookViewDto> findByTag(int idTag);
}
