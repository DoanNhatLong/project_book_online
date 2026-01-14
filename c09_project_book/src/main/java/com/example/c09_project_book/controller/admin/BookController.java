package com.example.c09_project_book.controller.admin;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.service.AccountService;
import com.example.c09_project_book.service.BookDetailDtoService;
import com.example.c09_project_book.service.IAccountService;
import com.example.c09_project_book.service.IBookDetailDtoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController",value = "/admin/book")
public class BookController extends HttpServlet {
    private IBookDetailDtoService bookDetailDtoService = new BookDetailDtoService();

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
            List<BookDetailDto> bookList = bookDetailDtoService.findAll();
            req.setAttribute("bookList", bookList);
            req.getRequestDispatcher("/views/admin/book/list.jsp").forward(req, resp);
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

    }

    private void lock(HttpServletRequest req, HttpServletResponse resp) {

    }
}
