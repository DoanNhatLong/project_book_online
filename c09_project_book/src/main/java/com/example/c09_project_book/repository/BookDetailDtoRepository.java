package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDetailDtoRepository implements  IBookDetailDtoRepository {
    private final String SELECT_ALL_BOOK ="select b.*,c.name as category_name from book b join category c on b.id_category =c.id where b.isdeleted =0;";
    private final String FIND_BOOK_BY_ID ="select * from book where id =? and isdeleted =0;";
    private final String INSERT_INTO ="INSERT INTO `book` (`name`, `price`, `stock`, `desc`, `author`, `image_url`, `id_category`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE_CONTENT ="update book set pdf_url =? where id =?;";
    @Override
    public BookDetailDto findByID(int bookId) throws SQLException {
        String sql= """
            
                select b.id,b.name,b.price,b.stock,b.desc,b.author,b.image_url, c.name as category
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
            book.setImageUrl(resultSet.getString("image_url"));
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
    public Book findById(int bookId) {

        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

            preparedStatement = connection.prepareStatement(FIND_BOOK_BY_ID);
            preparedStatement.setInt(1,bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");
                String desc = resultSet.getString("desc");
                String author = resultSet.getString("author");
                int categoryId = resultSet.getInt("id_category");
                String imageUrl = resultSet.getString("image_url");
                String pdfUrl = resultSet.getString("pdf_url");
                return new Book(id,name,price,stock,desc,author,categoryId,imageUrl,pdfUrl);

            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return null;
    }

    @Override
    public boolean addContent(int id, String pdfUrl) {
        try (Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(UPDATE_CONTENT);
            preparedStatement.setString(1, pdfUrl);
            preparedStatement.setDouble(2, id);
            int effecRow = preparedStatement.executeUpdate();
            return effecRow == 1;
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return false;
    }
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

    @Override
    public boolean updateStock(int id, int quantity) {
        String sql= """
                update book
                set stock= stock - ?
                where id=? and stock >= ?;
                """;
        Connection connection=BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2,id);
            preparedStatement.setInt(3,quantity);
            int effectRow= preparedStatement.executeUpdate();
            return effectRow>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBookById(int idBook) {
        String sql= """
                select *
                from book
                where id=? and isdeleted=0;
                """;
        Connection connection= BaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,idBook);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                int id= resultSet.getInt("id");
                String name= resultSet.getString("name");
                double price= resultSet.getDouble("price");
                int stock= resultSet.getInt("stock");
                String desc= resultSet.getString("desc");
                String author= resultSet.getString("author");
                int categoryId= resultSet.getInt("id_category");
                String imageUrl= resultSet.getString("image_url");
                String pdfUrl= resultSet.getString("pdf_url");
                return new Book(id,name,price,stock,desc,author,categoryId,imageUrl,pdfUrl);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
