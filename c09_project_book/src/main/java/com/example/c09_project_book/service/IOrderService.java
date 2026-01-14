package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Order;

import java.sql.SQLException;

public interface IOrderService {
    void addOrder(Order order) throws SQLException;
}
