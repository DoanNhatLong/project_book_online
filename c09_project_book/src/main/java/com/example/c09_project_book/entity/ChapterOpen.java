package com.example.c09_project_book.entity;

public class ChapterOpen {
    int idAccount;
    int idBook;
    int chapterOpen;

    public ChapterOpen() {
    }

    public ChapterOpen(int idAccount, int idBook, int chapterOpen) {
        this.idAccount = idAccount;
        this.idBook = idBook;
        this.chapterOpen = chapterOpen;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getChapterOpen() {
        return chapterOpen;
    }

    public void setChapterOpen(int chapterOpen) {
        this.chapterOpen = chapterOpen;
    }
}
