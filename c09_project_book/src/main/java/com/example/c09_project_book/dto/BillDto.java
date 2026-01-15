package com.example.c09_project_book.dto;

public class BillDto {
    int id;
    String name;
    String phone;
    String address;
    int idBook;
    String bookName;
    int quantity;

    public BillDto() {
    }

    public BillDto(int id, String name, String phone, String address, int idBook, String bookName, int quantity) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.idBook = idBook;
        this.bookName = bookName;
        this.quantity = quantity;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
