package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.Order;
import com.example.c09_project_book.entity.OrderItem;
import com.example.c09_project_book.repository.IOrderRepository;
import com.example.c09_project_book.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;

public class OrderService implements IOrderService {
    IOrderRepository orderRepository=new OrderRepository();

    @Override
    public void addOrder(Order order) throws SQLException {
        orderRepository.addOrder(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return orderRepository.deleteById(id);
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderRepository.saveOrder(order);
    }

    @Override
    public boolean saveOrder(Order order, int idEdit) {
        return orderRepository.saveOrder(order,idEdit);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public int getNew() {
        return orderRepository.getNew();
    }

}
