package com.example.c09_project_book.controller.admin;

import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.service.AccountService;
import com.example.c09_project_book.service.IAccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController",value = "/admin/accounts")
public class AccountController extends HttpServlet {
    private IAccountService accountService = new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                // trả về trang thêm mới
                search(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Account> accountList = accountService.findAll();
            req.setAttribute("accountList", accountList);
            req.getRequestDispatcher("/views/admin/account/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "lock":
                lock(req, resp);
                break;
            case "unlock":
                unlock(req, resp);
                break;
            default:
                break;
        }
    }

    private void unlock(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        boolean isUnlock= accountService.updateStatusAccount(username,true);
    }

    private void lock(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
    }
}
