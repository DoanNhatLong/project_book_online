package com.example.c09_project_book.entity;

public class Chapter {
    private int id;
    private int bookId;
    private boolean chapterUnlock;
    private int point;

    public Chapter() {
    }

    public Chapter(int id, int bookId, boolean chapterUnlock, int point) {
        this.id = id;
        this.bookId = bookId;
        this.chapterUnlock = chapterUnlock;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isChapterUnlock() {
        return chapterUnlock;
    }

    public void setChapterUnlock(boolean chapterUnlock) {
        this.chapterUnlock = chapterUnlock;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

