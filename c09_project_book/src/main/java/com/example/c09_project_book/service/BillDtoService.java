package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.BillDto;
import com.example.c09_project_book.repository.BillDtoRepository;
import com.example.c09_project_book.repository.IBillDtoRepository;

import java.util.List;

public class BillDtoService implements IBillDtoService {
    IBillDtoRepository billDtoRepository=new BillDtoRepository();

    @Override
    public List<BillDto> approve(int idOrder) {
        return billDtoRepository.approve(idOrder);
    }
}
