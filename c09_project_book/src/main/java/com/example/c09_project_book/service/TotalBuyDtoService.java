package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.TotalBuyDto;
import com.example.c09_project_book.repository.ITotalBuyDtoRepository;
import com.example.c09_project_book.repository.TotalBuyDtoRepository;

import java.util.List;

public class TotalBuyDtoService implements ITotalBuyDtoService {
    ITotalBuyDtoRepository totalBuyDtoRepository=new TotalBuyDtoRepository();

    @Override
    public List<TotalBuyDto> getAll() {
        return totalBuyDtoRepository.getAll();
    }
}
