package com.example.c09_project_book.dto;

import javax.xml.crypto.Data;
import java.sql.Date;

public class HistoryBuyDto {
    String bookName;
    Date buyTime;

    public HistoryBuyDto(String bookName, Date buyTime) {
        this.bookName = bookName;
        this.buyTime = buyTime;
    }

    public HistoryBuyDto() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }
}
