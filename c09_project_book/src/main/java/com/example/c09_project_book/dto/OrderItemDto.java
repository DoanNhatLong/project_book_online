package com.example.c09_project_book.dto;

public class OrderItemDto {
    int id_account;
    int id_book;
    int quantity;
    double price;

    public OrderItemDto() {
    }

    public OrderItemDto(int id_account, int id_book, int quantity, double price) {
        this.id_account = id_account;
        this.id_book = id_book;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
