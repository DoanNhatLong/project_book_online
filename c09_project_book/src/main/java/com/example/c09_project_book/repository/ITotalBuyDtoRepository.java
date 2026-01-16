package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.TotalBuyDto;

import java.util.List;

public interface ITotalBuyDtoRepository {
    List<TotalBuyDto> getAll();
}
