package com.example.c09_project_book.entity;

import java.sql.Date;

public class AccountChapter {
    private int id_account;
    private int id_chapter;
    private int point;
    private Date time;
    boolean isDeleted=false;

    public AccountChapter() {
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public AccountChapter(int id_account, int id_chapter, int point, Date time) {
        this.id_account = id_account;
        this.id_chapter = id_chapter;
        this.point = point;
        this.time = time;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getId_chapter() {
        return id_chapter;
    }

    public void setId_chapter(int id_chapter) {
        this.id_chapter = id_chapter;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
