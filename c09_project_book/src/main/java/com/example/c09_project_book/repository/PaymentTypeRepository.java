package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeRepository implements IPaymentTypeRepository {
    @Override
    public List<PaymentType> getAll() throws SQLException {
        List<PaymentType> paymentTypeList = new ArrayList<>();
        String sql = "SELECT * FROM payment_type WHERE isdeleted = false";
        Connection connection= BaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            PaymentType paymentType = new PaymentType();
            paymentType.setId(resultSet.getInt("id"));
            paymentType.setName(resultSet.getString("name"));
            paymentType.setRate(resultSet.getInt("rate"));
            paymentTypeList.add(paymentType);
        }
        return paymentTypeList;
    }
}
