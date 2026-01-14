package com.example.c09_project_book.dto;

public class ChapterDto {
    String name;
    int chapter_unlock;
    int point;

    public ChapterDto() {
    }

    public ChapterDto(String name, int chapter_unlock, int point) {
        this.name = name;
        this.chapter_unlock = chapter_unlock;
        this.point = point;
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
