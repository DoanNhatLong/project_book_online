package com.example.c09_project_book.dto;

public class UserInfoDto {
    int id_account;
    String name;
    String phone;
    String email;
    int point;

    public UserInfoDto() {
    }

    public UserInfoDto(int id_account, String name, String phone, String email, int point) {
        this.id_account = id_account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.point = point;
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
