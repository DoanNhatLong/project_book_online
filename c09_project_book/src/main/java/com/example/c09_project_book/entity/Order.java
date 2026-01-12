package com.example.c09_project_book.entity;
import java.sql.Date;

public class Order {
    private int id;
    private int customerId;
    private String status;
    private int total;
    private Date time;

    public Order() {
    }

    public Order(int id, int customerId, String status, int total, Date time) {
        this.id = id;
        this.customerId = customerId;
        this.status = status;
        this.total = total;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
