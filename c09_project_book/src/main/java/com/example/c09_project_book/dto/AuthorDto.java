package com.example.c09_project_book.dto;

public class AuthorDto {
    private String author;
    private int totalAuthor;

    public AuthorDto(String author, int totalAuthor) {
        this.author = author;
        this.totalAuthor = totalAuthor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalAuthor() {
        return totalAuthor;
    }

    public void setTotalAuthor(int totalAuthor) {
        this.totalAuthor = totalAuthor;
    }
}
