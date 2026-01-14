package com.example.c09_project_book.repository;

import com.example.c09_project_book.dto.ChapterDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChapterRepository implements IChapterRepository {

    /* long */
    @Override
    public ChapterDto findByIdBook(int id_book) throws SQLException {
        String sql= """
                select b.name,b.id, c.chapter_unlock, c.point
                from chapter c
                join book b on b.id=c.id_book
                where b.id=?;
                """;
        Connection connection=BaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,id_book);
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            ChapterDto chapterDto=new ChapterDto();
            chapterDto.setId_book(resultSet.getInt("id"));
            chapterDto.setName(resultSet.getString("name"));
            chapterDto.setChapter_unlock(resultSet.getInt("chapter_unlock"));
            chapterDto.setPoint(resultSet.getInt("point"));
            return chapterDto;
        }
        return null;
    }
}
