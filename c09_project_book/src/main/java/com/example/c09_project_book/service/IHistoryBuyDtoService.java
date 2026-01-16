package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.HistoryBuyDto;

import java.util.List;

public interface IHistoryBuyDtoService {
    List<HistoryBuyDto> getAll(int id);
}
