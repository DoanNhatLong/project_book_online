package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailDtoRepository implements  IBookDetailDtoRepository {
    private final String SELECT_ALL_BOOK ="select b.*,c.name as category_name, a.name as author_name from book b join category c on b.id_category =c.id join author a on b.id_author=a.id where b.isdeleted =0;";
    @Override
    public BookDetailDto findByID(int bookId) throws SQLException {
        String sql= """
            select b.id,b.name,b.price,b.stock,b.desc,a.name as author, c.name as category
            from book b
            join author a on b.id_author=a.id
            join category c on b.id_category=c.id
            where b.isdeleted=0 and b.id=?
            """;
        Connection connection= BaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,bookId);
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

    @Override
    public List<BookDetailDto> findAll() {
        List<BookDetailDto> bookDetailDtoList = new ArrayList<>();
        // Kết nối DB
        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

            preparedStatement = connection.prepareStatement(SELECT_ALL_BOOK);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");
                String desc = resultSet.getString("desc");
                String category= resultSet.getString("category_name");
                String author= resultSet.getString("author_name");
                BookDetailDto bookDetailDto = new BookDetailDto(id,name,price,stock,desc,author,category);
                bookDetailDtoList.add(bookDetailDto);
            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return bookDetailDtoList;

    }

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public boolean edit(int id, Book book) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
