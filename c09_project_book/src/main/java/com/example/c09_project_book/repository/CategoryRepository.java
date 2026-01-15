package com.example.c09_project_book.repository;
import com.example.c09_project_book.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    private static final String SELECT_ALL ="select * from category where isdeleted=0;";
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try(Connection connection = BaseConnection.getConnection()) {
            PreparedStatement preparedStatement= null;

            preparedStatement = connection.prepareStatement(SELECT_ALL);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            System.out.println("Loi truy van du lieu");
        }
        return categoryList;
    }
}
