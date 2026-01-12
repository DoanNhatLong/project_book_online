package com.example.c09_project_book.entity;

import java.sql.Date;

public class AccountChapter {
    private int accountId;
    private int chapterId;
    private int point;
    private Date time;

    public AccountChapter() {
    }

    public AccountChapter(int accountId, int chapterId, int point, Date time) {
        this.accountId = accountId;
        this.chapterId = chapterId;
        this.point = point;
        this.time = time;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
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
