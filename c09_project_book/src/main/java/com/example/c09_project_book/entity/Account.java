package com.example.c09_project_book.entity;

public class Account {
    private int id;
    private String name;
    private String password;
    private int bonusPoint;

    public Account() {
    }

    public Account(int id, String name, String password, int bonusPoint) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.bonusPoint = bonusPoint;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
}
