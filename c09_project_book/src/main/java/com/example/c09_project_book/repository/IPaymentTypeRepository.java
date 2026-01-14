package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.PaymentType;

import java.sql.SQLException;
import java.util.List;

public interface IPaymentTypeRepository {
    List<PaymentType> getAll() throws SQLException;
}
