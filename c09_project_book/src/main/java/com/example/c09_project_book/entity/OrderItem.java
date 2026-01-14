package com.example.c09_project_book.entity;

public class OrderItem {
    private int id_order;
    private int id_book;
    private int quantity;
    private double price;
    boolean isDeleted=false;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public OrderItem() {
    }

    public OrderItem(int id_order, int id_book, int quantity, double price) {
        this.id_order = id_order;
        this.id_book = id_book;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
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
