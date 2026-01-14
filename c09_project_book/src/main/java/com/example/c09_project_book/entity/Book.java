package com.example.c09_project_book.entity;

public class Book {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String desc;
    private int id_author;
    private int id_category;
    boolean isDeleted=false;
    public Book() {
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Book(int id, String name, double price, int stock, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.desc = desc;
    }

    public Book(int id, String name, double price, int stock,
                String desc, int id_author, int id_category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.desc = desc;
        this.id_author = id_author;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
