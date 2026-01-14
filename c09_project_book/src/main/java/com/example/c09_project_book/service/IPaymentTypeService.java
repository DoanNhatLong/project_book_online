package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.PaymentType;

import java.sql.SQLException;
import java.util.List;

public interface IPaymentTypeService {
    List<PaymentType> getAll() throws SQLException;
}
