package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.AuthorDto;
import com.example.c09_project_book.repository.AuthorDtoRepository;
import com.example.c09_project_book.repository.IAuthorDtoRepository;

import java.util.List;

public class AuthorDtoService implements IAuthorDtoService {
    IAuthorDtoRepository authorDtoRepository=new AuthorDtoRepository();

    @Override
    public List<AuthorDto> getAll() {
        return authorDtoRepository.getAll();
    }
}
