package com.example.c09_project_book.utils;


import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.AccountChapter;
import com.example.c09_project_book.repository.AccountChapterRepository;
import com.example.c09_project_book.repository.BaseConnection;
import com.example.c09_project_book.repository.IAccountChapterRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Library {
    public static IAccountChapterRepository accountChapterRepository = new AccountChapterRepository();

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

    public static int getPoint(int idAccount) {
        AccountChapter accountChapter = accountChapterRepository.findByAccountId(idAccount);
        if (accountChapter == null) {
            throw new RuntimeException("Không tìm thấy account_chapter với id_account = " + idAccount);
        }
        return accountChapter.getPoint();
    }

    public static boolean changePoint(int accountId, int deltaPoint) throws SQLException {
        String sql =
                "UPDATE account_chapter " +
                        "SET point = point + ? " +
                        "WHERE id_account = ? AND point + ? >= 0";

        try (Connection conn = BaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, deltaPoint);
            ps.setInt(2, accountId);
            ps.setInt(3, deltaPoint);

            int rows = ps.executeUpdate();
            return rows > 0;
        }
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

    public static void updatePointForUsed(HttpSession session, int deltaPoint) {
        Integer current = (Integer) session.getAttribute("pointOfAccount");
        if (current == null) current = 0;

        int newPoint = current + deltaPoint;

        if (newPoint < 0) newPoint = 0;

        session.setAttribute("pointOfAccount", newPoint);
    }

}
