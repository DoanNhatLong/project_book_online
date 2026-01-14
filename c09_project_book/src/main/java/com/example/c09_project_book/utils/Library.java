package com.example.c09_project_book.utils;

import com.example.c09_project_book.dto.UserInfoDto;
import com.example.c09_project_book.entity.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Library {
    public static int getAccountId(HttpServletRequest req) throws IllegalStateException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            throw new IllegalStateException("Session không tồn tại");
        }

        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            throw new IllegalStateException("Người dùng chưa đăng nhập");
        }

        return account.getId();
    }

}
