package com.example.c09_project_book.utils;


import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.AccountChapter;
import com.example.c09_project_book.repository.AccountChapterRepository;
import com.example.c09_project_book.repository.IAccountChapterRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;


public class Library {
    public static IAccountChapterRepository accountChapterRepository=new AccountChapterRepository();

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

    public static void changePoint(int idAccount, int pointChange) throws SQLException {

        AccountChapter accountChapter = accountChapterRepository.findByAccountId(idAccount);
        if (accountChapter == null) {
            throw new RuntimeException("Không tìm thấy account_chapter với id_account = " + idAccount);
        }
        int newPoint = accountChapter.getPoint() + pointChange;
        accountChapter.setPoint(newPoint);
        accountChapter.setId_account(idAccount);
        accountChapterRepository.update(accountChapter);
    }

    public static Integer requireLogin(HttpServletRequest req,
                                       HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/clients");
            return null;
        }

        Account account = (Account) session.getAttribute("account");

        if (account == null) {
            session.setAttribute("message", "Vui lòng đăng nhập");
            resp.sendRedirect(req.getContextPath() + "/clients");
            return null;
        }

        return account.getId();
    }

}
