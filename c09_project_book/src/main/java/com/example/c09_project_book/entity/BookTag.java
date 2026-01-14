package com.example.c09_project_book.entity;

public class BookTag {
    private int id_book;
    private int id_tag;
    boolean isDeleted=false;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public BookTag() {
    }

    public BookTag(int id_book, int id_tag) {
        this.id_book = id_book;
        this.id_tag = id_tag;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }
}

