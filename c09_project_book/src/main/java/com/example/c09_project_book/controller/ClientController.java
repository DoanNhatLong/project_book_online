package com.example.c09_project_book.controller;
import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.dto.BookViewDto;
import com.example.c09_project_book.repository.BookDetailDtoRepository;
import com.example.c09_project_book.repository.IBookDetailDtoRepository;
import com.example.c09_project_book.service.BookDetailDtoService;
import com.example.c09_project_book.service.BookViewDtoService;
import com.example.c09_project_book.service.IBookDetailDtoService;
import com.example.c09_project_book.service.IBookViewDtoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet (name = "ClientController", value = "/clients")
public class ClientController extends HttpServlet {
    IBookViewDtoService bookViewDtoService = new BookViewDtoService();
    IBookDetailDtoService bookDetailDtoService = new BookDetailDtoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "taglist" -> viewTagList(req, resp);
            case "book" -> {
                try {
                    viewBook(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "cart" -> {
                try {
                    goCart(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "user" -> goUser(req,resp);
            default -> goHome(req, resp);
        }
    }

    private void goUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
    }

    private void goCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        HttpSession session = req.getSession();
        Map<Integer, BookViewDto.CartItem> cart = (Map<Integer, BookViewDto.CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        String idParam = req.getParameter("id");
        String quantityParam = req.getParameter("quantity");
        if(idParam != null && quantityParam != null) {
            int bookId = Integer.parseInt(idParam);
            int quantity = Integer.parseInt(quantityParam);

            BookViewDto.CartItem item = cart.get(bookId);
            if(item == null) {
                BookDetailDto book = bookDetailDtoService.findByID(bookId);
                item = new BookViewDto.CartItem(book, quantity);
            } else {
                item.setQuantity(item.getQuantity() + quantity);
            }
            cart.put(bookId, item);
        }

        req.getRequestDispatcher("/views/client/cart.jsp").forward(req, resp);
    }

    private void viewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id_book= Integer.parseInt(req.getParameter("id"));
        BookDetailDto book=bookDetailDtoService.findByID(id_book);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/views/client/book.jsp").forward(req,resp);
    }

    private void viewTagList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("View tag list");
        int id_tag = Integer.parseInt(req.getParameter("tag"));
        System.out.println(id_tag);
        List<BookViewDto> list= bookViewDtoService.findByTag(id_tag);
        req.setAttribute("list_book", list);
        req.getRequestDispatcher("/views/client/taglist.jsp").forward(req,resp);
    }

    private void goHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/client/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
