package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository implements IOrderRepository {
    @Override
    public void addOrder(Order order) throws SQLException {
        String sql="insert into `order`(id_customer,total) values(?,?)";
        Connection connection=BaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1, order.getId_customer());
        preparedStatement.setInt(2, order.getTotal());
        preparedStatement.executeUpdate();
    }
}
