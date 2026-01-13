package com.example.c09_project_book.dto;

public class BookViewDto {
    int id;
    String name;
    double price;
    String authorName;

    public BookViewDto() {
    }

    public BookViewDto(int id, String name, double price, String authorName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.authorName = authorName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public static class CartItem {
        private BookDetailDto book;
        private int quantity;

        public CartItem() {}

        public CartItem(BookDetailDto book, int quantity) {
            this.book = book;
            this.quantity = quantity;
        }

        public BookDetailDto getBook() {
            return book;
        }

        public void setBook(BookDetailDto book) {
            this.book = book;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
