package com.example.c09_project_book.dto;

public class TotalBuyDto {
    String bookName;
    int totalBuy;

    public TotalBuyDto() {
    }

    public TotalBuyDto(String bookName, int totalBuy) {
        this.bookName = bookName;
        this.totalBuy = totalBuy;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalBuy() {
        return totalBuy;
    }

    public void setTotalBuy(int totalBuy) {
        this.totalBuy = totalBuy;
    }
}
