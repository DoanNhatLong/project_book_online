package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.HistoryBuyDto;

import java.util.List;

public interface IHistoryBuyDtoRepository {
    List<HistoryBuyDto> getAll(int id);
}
