package com.example.c09_project_book.entity;

import java.sql.Date;

public class AddPoint {
    private int id;
    private int accountId;
    private int orderId;
    private int point;
    private String type;
    private Date time;

    public AddPoint() {
    }

    public AddPoint(int id, int accountId, int orderId, int point, String type, Date time) {
        this.id = id;
        this.accountId = accountId;
        this.orderId = orderId;
        this.point = point;
        this.type = type;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
