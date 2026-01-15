package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BillDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDtoRepository implements IBillDtoRepository {


    @Override
    public List<BillDto> approve(int idOrder) {
        List<BillDto> list = new ArrayList<>();
        String sql = """
                select c.id as id_customer, c.name, c.phone,c.address,b.id as id_book, b.name as name_book, oi.quantity
                  from customer c
                  join `order` o on c.id=o.id_customer
                  join order_item oi on oi.id_order=o.id
                   join book b on b.id=oi.id_book
                  where o.isdeleted=0 and o.id=?;
                """;
        Connection connection = BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOrder);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BillDto billDto = new BillDto();
                billDto.setId(resultSet.getInt("id_customer"));
                billDto.setName(resultSet.getString("name"));
                billDto.setPhone(resultSet.getString("phone"));
                billDto.setAddress(resultSet.getString("address"));
                billDto.setIdBook(resultSet.getInt("id_book"));
                billDto.setBookName(resultSet.getString("name_book"));
                billDto.setQuantity(resultSet.getInt("quantity"));
                list.add(billDto);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
