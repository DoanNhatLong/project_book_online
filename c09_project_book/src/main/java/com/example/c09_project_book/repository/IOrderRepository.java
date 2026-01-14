package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Order;

import java.sql.SQLException;

public interface IOrderRepository {
    void addOrder(Order order) throws SQLException;
}
