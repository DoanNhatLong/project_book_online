package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BillDto;

import java.util.List;

public interface IBillDtoRepository {
    List<BillDto> approve(int idOrder);
}
