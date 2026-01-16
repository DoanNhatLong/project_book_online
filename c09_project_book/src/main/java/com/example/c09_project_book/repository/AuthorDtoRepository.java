package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.AuthorDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDtoRepository implements IAuthorDtoRepository {
    @Override
    public List<AuthorDto> getAll() {
        List<AuthorDto> list=new ArrayList<>();
        String sql = """
                select b.author, sum(oi.quantity) as total_author
                from book b
                join order_item oi on  b.id=oi.id_book
                group by b.author
                order by total_author desc
                limit 5
                """;
        Connection connection= BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String author=resultSet.getString("author");
                int totalAuthor=resultSet.getInt("total_author");
                AuthorDto authorDto=new AuthorDto(author,totalAuthor);
                list.add(authorDto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
