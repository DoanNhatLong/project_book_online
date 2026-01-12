package com.example.c09_project_book.controller;

import com.example.c09_project_book.repository.BaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = BaseConnection.getConnection()) {
            System.out.println("Kết nối thành công!");
        }
    }
}
