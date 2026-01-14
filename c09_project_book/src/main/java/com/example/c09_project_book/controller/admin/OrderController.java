package com.example.c09_project_book.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "OrderController",value = "/admin/order")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về trang thêm mới
                showFormAdd(req, resp);
                break;
            case "edit":
                // trả về trang thêm mới
                showFormEdit(req, resp);
                break;
            case "search":
                // trả về trang thêm mới
                search(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("views/admin/user/list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
    }
}
