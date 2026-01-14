package com.example.c09_project_book.dto;

public class BookDetailDto {
    int id;
    String name;
    double price;
    int stock;
    String desc;
    String author;
    String category;

    public BookDetailDto() {
    }

    public BookDetailDto(int id, String name, double price, int stock, String desc, String author, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.desc = desc;
        this.author = author;
        this.category = category;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
