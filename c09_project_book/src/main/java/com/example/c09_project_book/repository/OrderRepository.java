package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = "insert into `order`(id_customer,total,time) values(?,?,?)";
        Connection connection = BaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, order.getId_customer());
        preparedStatement.setInt(2, order.getTotal());
        preparedStatement.setDate(3, order.getTime());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        String sql = "select * from `order` where isdeleted=0 order by time desc;";
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setId_customer(resultSet.getInt("id_customer"));
                order.setTotal(resultSet.getInt("total"));
                order.setTime(resultSet.getDate("time"));
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "update `order` set isdeleted=1 where id=?";
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int row= preparedStatement.executeUpdate();
            return row>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
