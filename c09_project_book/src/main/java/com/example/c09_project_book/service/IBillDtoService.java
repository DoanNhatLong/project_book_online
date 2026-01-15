package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BillDto;

import java.util.List;

public interface IBillDtoService {
    List<BillDto> approve(int idOrder);
}
