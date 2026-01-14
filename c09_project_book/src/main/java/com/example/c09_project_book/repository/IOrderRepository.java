package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface IOrderRepository {
    void addOrder(Order order) throws SQLException;
    /* long */
    List<Order> findAll();
    boolean deleteById(int id);
}
