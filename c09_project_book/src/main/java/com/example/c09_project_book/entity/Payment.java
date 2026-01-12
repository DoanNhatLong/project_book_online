package com.example.c09_project_book.entity;

public class Payment {
    private int id;
    private int orderId;
    private int typeId;
    private String status;

    public Payment() {
    }

    public Payment(int id, int orderId, int typeId, String status) {
        this.id = id;
        this.orderId = orderId;
        this.typeId = typeId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}