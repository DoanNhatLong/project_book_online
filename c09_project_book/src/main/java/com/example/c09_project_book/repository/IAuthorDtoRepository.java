package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.AuthorDto;

import java.util.List;

public interface IAuthorDtoRepository {
    List<AuthorDto> getAll();
}
