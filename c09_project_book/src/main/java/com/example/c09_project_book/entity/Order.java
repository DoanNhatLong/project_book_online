package com.example.c09_project_book.entity;
import java.sql.Date;

public class Order {
    private int id;
    private int id_customer;
    private String status;
    private int total;
    private Date time;
    boolean isDeleted=false;

    public Order() {
    }

    public Order(int id_customer, int total) {
        this.id_customer = id_customer;
        this.total = total;
    }

    public Order(int id_customer, int total, Date time) {
        this.id_customer = id_customer;
        this.total = total;
        this.time = time;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Order(int id, int id_customer, String status, int total, Date time) {
        this.id = id;
        this.id_customer = id_customer;
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

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
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
