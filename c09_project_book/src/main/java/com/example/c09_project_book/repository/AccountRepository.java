package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private final String SELECT_ALL = "select * from account where isdeleted =0 and role<>'ADMIN';";
    private final String FIND_BY_USERNAME = "select * from account where isdeleted =0 and username=?;";
    private final String UPDATE = "update account set islocked =? where  isdeleted =0 and id =?;";
    private final String SEARCH_NAME = "select s.*, c.name as class_name from students s join classes c on s.class_id=c.id where s.name like ?;";
    private final String INSERT_INTO = " insert into students(name,gender,score,class_id) values(?,?,?,?);";

    @Override
    public Account findAccount(String username, String password) throws SQLException {
        Connection connection = BaseConnection.getConnection();
        String sql = "select * from account where username=? and password=? and isdeleted=0 and islocked=0";
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
                String role = resultSet.getString("role");
                boolean isLocked = resultSet.getBoolean("islocked");
                Account account = new Account(id,name,role,isLocked);
                accountList.add(account);
            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return accountList;
    }

    @Override
    public List<Account> searchByUsername(String username) {
        return List.of();
    }

    @Override
    public Account findAccountByUsername(String username) {

        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

            preparedStatement = connection.prepareStatement(FIND_BY_USERNAME);
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("username");
                String role = resultSet.getString("role");
                boolean isLocked = resultSet.getBoolean("islocked");
                return new Account(id,name,role,isLocked);
            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return null;
    }

    @Override
    public boolean updateStatusAccount(int id,boolean status) {
        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setBoolean(1,status);
            preparedStatement.setInt(2,id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return false;
    }
}
