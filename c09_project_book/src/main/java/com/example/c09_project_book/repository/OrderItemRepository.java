package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemRepository implements IOrderItemRepository {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql = "INSERT INTO order_item (id_order, id_book, quantity, price) VALUES (?, ?, ?, ?)";
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderItem.getId_order());
            preparedStatement.setInt(2, orderItem.getId_book());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setDouble(4, orderItem.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
