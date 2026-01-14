package com.example.c09_project_book.service;

import com.example.c09_project_book.dto.ChapterDto;
import com.example.c09_project_book.repository.ChapterRepository;
import com.example.c09_project_book.repository.IChapterRepository;

import java.sql.SQLException;

public class ChapterDtoService implements IChapterDtoService {
    IChapterRepository chapterRepository=new ChapterRepository();
    @Override
    public ChapterDto findByIdBook(int id_book) throws SQLException {
        return chapterRepository.findByIdBook(id_book) ;
    }
}
