package com.example.c09_project_book.service;

import com.example.c09_project_book.entity.OrderItem;
import com.example.c09_project_book.repository.IOrderItemRepository;
import com.example.c09_project_book.repository.OrderItemRepository;

public class OrderItemService implements IOrderItemService {
    IOrderItemRepository orderItemRepository=new OrderItemRepository();

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.addOrderItem(orderItem);
    }
}
