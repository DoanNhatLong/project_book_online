package com.example.c09_project_book.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/project_c09_book_online";
    private static final String USER = "root";
    private static final String PASSWORD = "codegym";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Không thể kết nối DB", e);
        }
    }
}
