package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    void addOrder(Order order) throws SQLException;
    List<Order> findAll();

    boolean deleteById(int id);
}
