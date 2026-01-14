package com.example.c09_project_book.dto;

public class ChapterDto {
    int id_book;
    String name;
    int chapter_unlock;
    int point;

    public ChapterDto() {
    }

    public ChapterDto(int id_book, String name, int chapter_unlock, int point) {
        this.id_book = id_book;
        this.name = name;
        this.chapter_unlock = chapter_unlock;
        this.point = point;
    }

    public ChapterDto(String name, int chapter_unlock, int point) {
        this.name = name;
        this.chapter_unlock = chapter_unlock;
        this.point = point;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapter_unlock() {
        return chapter_unlock;
    }

    public void setChapter_unlock(int chapter_unlock) {
        this.chapter_unlock = chapter_unlock;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
