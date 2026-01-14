package com.example.c09_project_book.controller;

import com.example.c09_project_book.dto.*;
import com.example.c09_project_book.entity.Account;
import com.example.c09_project_book.entity.AccountChapter;
import com.example.c09_project_book.entity.Customer;
import com.example.c09_project_book.entity.Order;
import com.example.c09_project_book.service.*;
import com.example.c09_project_book.utils.Library;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet(name = "ClientController", value = "/clients")
public class ClientController extends HttpServlet {
    IBookViewDtoService bookViewDtoService = new BookViewDtoService();
    IBookDetailDtoService bookDetailDtoService = new BookDetailDtoService();
    ICustomerService customerService = new CustomerService();
    IAccountChapterService accountChapterService = new AccountChapterService();
    IOrderService orderService=new OrderService();
    IChapterDtoService chapterDtoService=new ChapterDtoService();

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
                    goCart(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "user" -> goUser(req, resp);
            case "checkout" -> goCheckOut(req, resp);
            case "info" -> goInfo(req, resp);
            case "removeCart" -> removeCart(req,resp);
            case "read"-> readBook(req,resp);
            case "readChapter" -> readChapter(req,resp);
            case "multiSearch" -> multiSearchBook(req,resp);

            default -> goHome(req, resp);
        }
    }

    private void multiSearchBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/client/multisearch.jsp").forward(req,resp);
    }

    private void unlockChapter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        HttpSession session= req.getSession();
        int chapter= Integer.parseInt(req.getParameter("chapter"));
        int cost= Integer.parseInt(req.getParameter("cost"))*-1;
        int openChapter= (int) session.getAttribute("openChapter");
        if (chapter==openChapter+1) {
            session.setAttribute("openChapter", openChapter + 1);
            session.setAttribute("message", "Đã trừ point và mở khóa chương " + chapter);
        }
        Library.changePoint(Library.getAccountId(req),cost );
        req.getRequestDispatcher("/views/client/chapter.jsp").forward(req,resp);
    }

    private void readChapter(HttpServletRequest req, HttpServletResponse resp) {
        String bookName=req.getParameter("bookName");
        int chapter= Integer.parseInt(req.getParameter("chapter"));

    }

    private void readBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_book = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        Integer openChapter = (Integer) session.getAttribute("openChapter");
        if (openChapter == null) {
            session.setAttribute("openChapter", 1);
        }
        ChapterDto chapterDto;
        try {
            chapterDto = chapterDtoService.findByIdBook(id_book);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("chapter", chapterDto);
        req.getRequestDispatcher("/views/client/chapter.jsp").forward(req,resp);
    }

    private void removeCart(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session= req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart!=null) {
            int id_book = Integer.parseInt(req.getParameter("id"));
            cart.remove(id_book);
        }
        try {
            resp.sendRedirect("/views/client/cart.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void goInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            session.setAttribute("message", "Vui lòng đăng nhập");
            resp.sendRedirect(req.getContextPath() + "/clients");
            return;
        }
        int id_account = account.getId();
        System.out.println(id_account);
        Customer customer = customerService.findByAccountId(id_account);
        AccountChapter accountChapter = accountChapterService.findByAccountId(id_account);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId_account(id_account);
        userInfoDto.setName(customer.getName());
        userInfoDto.setPhone(customer.getPhone());
        userInfoDto.setEmail(customer.getEmail());
        userInfoDto.setPoint(accountChapter.getPoint());
        session.setAttribute("userInfo", userInfoDto);
        req.getRequestDispatcher("/views/client/info.jsp").forward(req, resp);
    }


    private void goCheckOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        IPaymentTypeService paymentTypeService = new PaymentTypeService();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            req.setAttribute("loginRequired",
                    "Vui lòng đăng nhập để thanh toán");
            req.getRequestDispatcher("/views/client/cart.jsp")
                    .forward(req, resp);
            return;
        }
        int id_account = account.getId();
        List<OrderItemDto> list = new ArrayList<>();
        for (CartItem cartItem : cart.values()) {
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setId_account(id_account);
            orderItemDto.setId_book(cartItem.getBook().getId());
            orderItemDto.setQuantity(cartItem.getQuantity());
            orderItemDto.setPrice(cartItem.getBook().getPrice());
            list.add(orderItemDto);
        }
        try {
            req.setAttribute("paymentTypes", paymentTypeService.getAll());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        session.setAttribute("checkoutItems", list);
        req.getRequestDispatcher("/views/client/checkout.jsp").forward(req, resp);

    }

    private void goUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
    }

    private void goCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        HttpSession session = req.getSession();
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        String idParam = req.getParameter("id");
        String quantityParam = req.getParameter("quantity");
        if (idParam != null && quantityParam != null) {
            int bookId = Integer.parseInt(idParam);
            int quantity = Integer.parseInt(quantityParam);

            CartItem item = cart.get(bookId);
            if (item == null) {
                BookDetailDto book = bookDetailDtoService.findByID(bookId);
                item = new CartItem(book, quantity);
            } else {
                item.setQuantity(item.getQuantity() + quantity);
            }
            cart.put(bookId, item);
        }

        req.getRequestDispatcher("/views/client/cart.jsp").forward(req, resp);
    }

    private void viewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id_book = Integer.parseInt(req.getParameter("id"));
        BookDetailDto book = bookDetailDtoService.findByID(id_book);
        req.setAttribute("book", book);
        req.getRequestDispatcher("/views/client/book.jsp").forward(req, resp);
    }

    private void viewTagList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("View tag list");
        int id_tag = Integer.parseInt(req.getParameter("tag"));
        System.out.println(id_tag);
        List<BookViewDto> list = bookViewDtoService.findByTag(id_tag);
        req.setAttribute("list_book", list);
        req.getRequestDispatcher("/views/client/taglist.jsp").forward(req, resp);
    }

    private void goHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "book" -> {
                try {
                    viewBook(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "processCheckout" -> processCheckout(req, resp);
            case "checkout" -> goCheckOut(req, resp);
            case"searchBook" -> searchBook(req,resp);
            case "unlockChapter" -> {
                try {
                    unlockChapter(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> goHome(req, resp);
        }
    }

    private void searchBook(HttpServletRequest req, HttpServletResponse resp) {
        String keyword = req.getParameter("keyword");
        System.out.println("Keyword: " + keyword);
        List<BookViewDto> list = bookViewDtoService.searchByKeyword(keyword);
        req.setAttribute("list_book", list);
        try {
            req.getRequestDispatcher("/views/client/taglist.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processCheckout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        int total = Integer.parseInt(req.getParameter("total"));
        Account account = (Account) session.getAttribute("account");
        if (account == null) {
            session.setAttribute("message", "Vui lòng đăng nhập để thanh toán");
            try {
                resp.sendRedirect(req.getContextPath() + "/clients");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        int id_account = account.getId();
        Customer customer = customerService.findByAccountId(id_account);

        if (customer == null) {
            session.setAttribute("message", "Vui lòng cập nhật thông tin khách hàng trước khi thanh toán");
            resp.sendRedirect(req.getContextPath() + "/clients?action=info");
            return;
        }
        int id_customer= customer.getId();
        AccountChapter accountChapter = accountChapterService.findByAccountId(id_account);
        int point_gain = (int) Math.ceil(total / 100.0);
        int new_point = accountChapter.getPoint() + point_gain;
        accountChapter.setId_account(id_account);
        accountChapter.setPoint(new_point);
        Date time= (Date.valueOf(LocalDate.now()));
        try {
            accountChapterService.update(accountChapter);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Order order=new Order(id_account,total,time);
        try {
            orderService.addOrder(order);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        UserInfoDto userInfo = (UserInfoDto) session.getAttribute("userInfo");
        if (userInfo == null) {
            userInfo = new UserInfoDto();
            userInfo.setId_account(id_account);
        }
        userInfo.setPoint(new_point);
        session.setAttribute("userInfo", userInfo);
        session.setAttribute("message", "Bạn đã nhận được " + point_gain + " điểm thưởng!");
        session.setAttribute("cart", new HashMap<Integer, CartItem>());
        try {
            resp.sendRedirect(req.getContextPath() + "/clients");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
