package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.ChapterDto;

import java.sql.SQLException;

public interface IChapterRepository {
    ChapterDto findByIdBook(int id_book) throws SQLException;
}
