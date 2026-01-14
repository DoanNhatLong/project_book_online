package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public Customer findByAccountId(int idAccount) {
        String sql = "select * from customer where id_account=?";
        Connection connection=BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                Customer customer=new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName( resultSet.getString("name"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
