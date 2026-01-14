package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private final String SELECT_ALL = "select * from account;";
    private final String SEARCH_NAME = "select s.*, c.name as class_name from students s join classes c on s.class_id=c.id where s.name like ?;";
    private final String INSERT_INTO = " insert into students(name,gender,score,class_id) values(?,?,?,?);";

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

    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

                preparedStatement = connection.prepareStatement(SELECT_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String role = resultSet.getString("type");
                Account account = new Account(id,name,role);
                accountList.add(account);
            }
        } catch (SQLException e) {
            System.out.println("lỗi do truỳ vấn dữ liệu");
        }
        return accountList;
    }

    @Override
    public List<Account> searchByUsername(String username) {
        return List.of();
    }

    @Override
    public List<Account> updateStatusAccount(String username) {
        return List.of();
    }
}
