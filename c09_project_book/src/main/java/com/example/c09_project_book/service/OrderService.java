package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Order;
import com.example.c09_project_book.repository.IOrderRepository;
import com.example.c09_project_book.repository.OrderRepository;

import java.sql.SQLException;

public class OrderService implements IOrderService {
    IOrderRepository orderRepository=new OrderRepository();

    @Override
    public void addOrder(Order order) throws SQLException {
        orderRepository.addOrder(order);
    }
}
