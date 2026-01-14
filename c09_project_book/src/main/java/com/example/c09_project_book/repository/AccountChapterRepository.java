package com.example.c09_project_book.repository;

import com.example.c09_project_book.entity.AccountChapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountChapterRepository implements IAccountChapterRepository {
    @Override
    public AccountChapter findByAccountId(int idAccount) {
        String sql = "select * from account_chapter where id_account=? ";
        Connection connection=BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAccount);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                AccountChapter accountChapter=new AccountChapter();
                accountChapter.setPoint(resultSet.getInt("point"));
                return accountChapter;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(AccountChapter accountChapter) throws SQLException {
        String sql="update account_chapter set point=? where id_account=?";
        Connection connection =BaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1, accountChapter.getPoint());
        preparedStatement.setInt(2, accountChapter.getId_account());
        preparedStatement.executeUpdate();
    }
}
