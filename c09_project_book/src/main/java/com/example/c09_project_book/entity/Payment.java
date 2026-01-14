package com.example.c09_project_book.entity;

public class Payment {
    private int id;
    private int id_order;
    private int id_type;
    private String status;
    boolean isDeleted=false;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Payment() {
    }

    public Payment(int id, int id_order, int id_type, String status) {
        this.id = id;
        this.id_order = id_order;
        this.id_type = id_type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}