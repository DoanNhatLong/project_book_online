package com.example.c09_project_book.dao;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.repository.BaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailDao {
    public static BookDetailDto findByID(int id) throws SQLException {
        String sql= """
            select b.id,b.name,b.price,b.stock,b.desc,a.name as author, c.name as category
            from book b
            join author a on b.id_author=a.id
            join category c on b.id_category=c.id
            where b.id=?
            """;
        Connection connection= BaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            BookDetailDto book=new BookDetailDto();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setPrice(resultSet.getDouble("price"));
            book.setStock(resultSet.getInt("stock"));
            book.setDesc(resultSet.getString("desc"));
            book.setAuthor(resultSet.getString("author"));
            book.setCategory(resultSet.getString("category"));
            return book;
        }
        return null;
    }
}
