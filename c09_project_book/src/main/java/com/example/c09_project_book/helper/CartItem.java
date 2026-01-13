package com.example.c09_project_book.helper;

import com.example.c09_project_book.dto.BookDetailDto;

public class CartItem {
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
