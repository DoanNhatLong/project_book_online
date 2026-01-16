package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.Order;
import com.example.c09_project_book.entity.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface IOrderService {
    void addOrder(Order order) throws SQLException;
    List<Order> findAll();

    boolean deleteById(int id);

    boolean saveOrder(Order order);

    boolean saveOrder(Order order, int idEdit);

    Order findById(int id);

    int getNew();

}
