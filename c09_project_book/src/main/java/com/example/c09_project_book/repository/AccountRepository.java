package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository implements IAccountRepository {
    @Override
    public Account findAccount(String username, String password) throws SQLException {
        Connection connection = BaseConnection.getConnection();
        String sql = "select * from account where username=? and password=? and isdeleted=0";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Account(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("role")
            );
        }
        return null;
    }
}
