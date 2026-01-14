package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.PaymentType;
import com.example.c09_project_book.repository.IPaymentTypeRepository;
import com.example.c09_project_book.repository.PaymentTypeRepository;

import java.sql.SQLException;
import java.util.List;

public class PaymentTypeService implements IPaymentTypeService {
    IPaymentTypeRepository paymentTypeRepository=new PaymentTypeRepository();
    @Override
    public List<PaymentType> getAll() throws SQLException {
        return paymentTypeRepository.getAll();
    }
}
