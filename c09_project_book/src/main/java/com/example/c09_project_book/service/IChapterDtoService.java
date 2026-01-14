package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.ChapterDto;

import java.sql.SQLException;

public interface IChapterDtoService {
    ChapterDto findByIdBook(int id_book) throws SQLException;
}
