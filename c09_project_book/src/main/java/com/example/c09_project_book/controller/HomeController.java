package com.example.c09_project_book.controller;

import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.dto.TotalBuyDto;
import com.example.c09_project_book.repository.BookDetailDtoRepository;
import com.example.c09_project_book.repository.IBookDetailDtoRepository;
import com.example.c09_project_book.service.ITotalBuyDtoService;
import com.example.c09_project_book.service.TotalBuyDtoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    IBookDetailDtoRepository bookDetailDtoRepository = new BookDetailDtoRepository();
    ITotalBuyDtoService totalBuyDtoService=new TotalBuyDtoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<BookDetailDto> initBookList = bookDetailDtoRepository.findAll();
        session.setAttribute("initBookList", initBookList);
        List<TotalBuyDto> totalBuy= totalBuyDtoService.getAll();
        session.setAttribute("totalBuy",totalBuy);
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }
}
