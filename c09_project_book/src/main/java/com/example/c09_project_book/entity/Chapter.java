package com.example.c09_project_book.entity;

public class Chapter {
    private int id;
    private int id_book;
    private boolean chapter_unlock;
    private int point;
    boolean isDeleted=false;

    public Chapter() {
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Chapter(int id, int bookId, boolean chapter_unlock, int point) {
        this.id = id;
        this.id_book = bookId;
        this.chapter_unlock = chapter_unlock;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return id_book;
    }

    public void setBookId(int bookId) {
        this.id_book = bookId;
    }

    public boolean isChapter_unlock() {
        return chapter_unlock;
    }

    public void setChapter_unlock(boolean chapter_unlock) {
        this.chapter_unlock = chapter_unlock;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

