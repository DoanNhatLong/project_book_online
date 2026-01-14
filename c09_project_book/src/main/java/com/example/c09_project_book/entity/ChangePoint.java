package com.example.c09_project_book.entity;

import java.sql.Date;

public class ChangePoint {
    private int id;
    private int id_account;
    private int id_order;
    private int point;
    private String type;
    private Date time;
    boolean isDeleted=false;

    public ChangePoint() {
    }

    public ChangePoint(int id, int id_account, int id_order, int point, String type, Date time) {
        this.id = id;
        this.id_account = id_account;
        this.id_order = id_order;
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

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
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
