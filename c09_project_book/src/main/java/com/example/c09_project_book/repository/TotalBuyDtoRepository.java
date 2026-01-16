package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.TotalBuyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TotalBuyDtoRepository implements  ITotalBuyDtoRepository {
    @Override
    public List<TotalBuyDto> getAll() {
        List<TotalBuyDto> list=new ArrayList<>();
        String sql= """
                select b.name as book_name, sum(oi.quantity) as total_buy
                from book b
                join order_item oi on b.id=oi.id_book
                group by b.name
                order by total_buy desc
                limit 3;
                """;
        Connection connection=BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String bookName=resultSet.getString("book_name");
                int totalBuy=resultSet.getInt("total_buy");
                TotalBuyDto totalBuyDto=new TotalBuyDto(bookName,totalBuy);
                list.add(totalBuyDto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
