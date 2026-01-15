package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookViewDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookViewDtoRepository implements IBookViewDtoRepository {
    @Override
    public List<BookViewDto> findByTag(int id_tag) {
        List<BookViewDto> bookList = new ArrayList<>();
        String sql = """
                    SELECT b.*
                FROM book b
                JOIN book_tag bt ON b.id = bt.id_book
                WHERE b.isdeleted=0 and bt.id_tag = ?;
                """;
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_tag);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookViewDto book = new BookViewDto();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthorName(resultSet.getString("author"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookViewDto> searchByKeyword(String keyword) {
        List<BookViewDto> list= new ArrayList<>();
        String sql = """
select * from book where isdeleted=0 and name like ?
""";
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                BookViewDto book = new BookViewDto();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthorName(resultSet.getString("author"));
                list.add(book);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

