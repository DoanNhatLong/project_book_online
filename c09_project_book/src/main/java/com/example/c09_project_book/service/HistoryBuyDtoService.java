package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.HistoryBuyDto;
import com.example.c09_project_book.repository.HistoryBuyDtoRepository;
import com.example.c09_project_book.repository.IHistoryBuyDtoRepository;

import java.util.List;

public class HistoryBuyDtoService implements IHistoryBuyDtoService {
    IHistoryBuyDtoRepository historyBuyDtoRepository=new HistoryBuyDtoRepository();

    @Override
    public List<HistoryBuyDto> getAll(int id) {
        return historyBuyDtoRepository.getAll(id);
    }
}
