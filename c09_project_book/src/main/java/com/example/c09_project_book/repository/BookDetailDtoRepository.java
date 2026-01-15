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
    private final String SELECT_ALL_BOOK ="select b.*,c.name as category_name from book b join category c on b.id_category =c.id where b.isdeleted =0;";
    private final String INSERT_INTO ="INSERT INTO `book` (`name`, `price`, `stock`, `desc`, `author`, `image_url`, `id_category`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    @Override
    public BookDetailDto findByID(int bookId) throws SQLException {
        String sql= """
            
                select b.id,b.name,b.price,b.stock,b.desc,b.author, c.name as category
                                          from book b
                                          join category c on b.id_category=c.id
                                          where b.isdeleted=0 and b.id=?;
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
                String author= resultSet.getString("author");
                String imageUrl= resultSet.getString("image_url");
                BookDetailDto bookDetailDto = new BookDetailDto(id,name,price,stock,desc,author,category,imageUrl);
                bookDetailDtoList.add(bookDetailDto);
            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return bookDetailDtoList;

    }

    @Override
    public boolean add(Book book) {
        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;
//            (`name`, `price`, `stock`, `desc`, `author`, `image_url`, `id_category`)
            preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setDouble(2,book.getPrice());
            preparedStatement.setInt(3,book.getStock());
            preparedStatement.setString(4,book.getDesc());
            preparedStatement.setString(5,book.getAuthor());
            preparedStatement.setString(6,book.getImageUrl());
            preparedStatement.setInt(7,book.getId_category());
            int effecRow=  preparedStatement.executeUpdate();
            return effecRow==1;
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
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

    @Override
    public List<BookDetailDto> searchByMulti(String author, String bookName, Double price) {
        String sql= """
                SELECT *
                FROM book
                WHERE isdeleted=0
                AND (? IS NULL OR author LIKE ?)
                AND (? IS NULL OR name LIKE ?)
                AND (? IS NULL OR price <= ?);
                """;
        List<BookDetailDto> list=new ArrayList<>();
        Connection connection= BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,author);
            preparedStatement.setString(2,author==null?null:"%"+author+"%");
            preparedStatement.setString(3,bookName);
            preparedStatement.setString(4,bookName==null?null:"%"+bookName+"%");
            if (price==null){
                preparedStatement.setNull(5,java.sql.Types.DOUBLE);
                preparedStatement.setNull(6,java.sql.Types.DOUBLE);
            }else {
                preparedStatement.setDouble(5,price);
                preparedStatement.setDouble(6,price);
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                BookDetailDto book=new BookDetailDto();
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                list.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
