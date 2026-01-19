package com.example.c09_project_book.controller;

import com.example.c09_project_book.dto.HistoryBuyDto;
import com.example.c09_project_book.dto.TotalBuyDto;
import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.service.*;
import com.example.c09_project_book.utils.Library;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private IAccountService accountService = new AccountService();
    IHistoryBuyDtoService historyBuyDtoService=new HistoryBuyDtoService();
    ITotalBuyDtoService totalBuyDtoService=new TotalBuyDtoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account;
        try {
            account = accountService.findAccount(username, password);
            System.out.println(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (account == null) {
            req.setAttribute("error", "Tài khoản không tồn tại");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("account", account);
        int point = Library.getPoint(account.getId());
        session.setAttribute("pointOfAccount", point);
        List<HistoryBuyDto> historyBuyDto = historyBuyDtoService.getAll(account.getId());
        session.setAttribute("historyList", historyBuyDto);
        if (account.getRole().equals("ADMIN")) {
            resp.sendRedirect("/admin/account");
        } else {
            resp.sendRedirect("/views/home.jsp");
        }
    }
}
