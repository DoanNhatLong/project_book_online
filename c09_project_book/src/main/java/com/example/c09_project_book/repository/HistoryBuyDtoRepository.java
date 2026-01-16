package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.HistoryBuyDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryBuyDtoRepository implements IHistoryBuyDtoRepository {
    @Override
    public List<HistoryBuyDto> getAll(int id) {
        List<HistoryBuyDto> list=new ArrayList<>();
        String sql= """
                select b.name as book_name, o.time as buy_time
                   from book b
                   join order_item oi on b.id=oi.id_book
                   join `order` o on o.id=oi.id_order
                   join customer c on c.id=o.id_customer
                   join account a on c.id_account = a.id
                   where  a.isdeleted=0 and a.id=?;
                """;
        Connection connection=BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String bookName=resultSet.getString("book_name");
                java.sql.Date buyTime=resultSet.getDate("buy_time");
                HistoryBuyDto historyBuyDto=new HistoryBuyDto();
                historyBuyDto.setBookName(bookName);
                historyBuyDto.setBuyTime(buyTime);
                list.add(historyBuyDto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
