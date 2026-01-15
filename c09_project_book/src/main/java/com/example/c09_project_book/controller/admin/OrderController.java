package com.example.c09_project_book.controller.admin;

import com.example.c09_project_book.dto.BillDto;
import com.example.c09_project_book.entity.Book;
import com.example.c09_project_book.entity.Order;
import com.example.c09_project_book.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "OrderController", value = "/admin/order")
public class OrderController extends HttpServlet {
    IOrderService orderService = new OrderService();
    IBillDtoService billDtoService = new BillDtoService();
    IBookDetailDtoService bookDetailDtoService=new BookDetailDtoService();

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
            /*long*/
            case "delete":
                deleteById(req, resp);
                break;
            case "approve":
                approve(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/views/admin/order/add.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        int idEdit = Integer.parseInt(req.getParameter("id"));
        try {
            req.setAttribute("idEdit", idEdit);
            req.getRequestDispatcher("/views/admin/order/edit.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Order> orderList = orderService.findAll();
            req.setAttribute("orderList", orderList);
            req.getRequestDispatcher("/views/admin/order/list.jsp").forward(req, resp);
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
            case "save":
                save(req, resp);
                break;
            case "edit":
                // trả về trang thêm mới
                editOrder(req, resp);
                break;
            case "search":
                // trả về trang thêm mới
                search(req, resp);
                break;
            case "confirmApprove":
                confirmApprove(req, resp);
                break;

            default:
                showList(req, resp);
                break;
        }

    }

    private void confirmApprove(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session= req.getSession();
        List<BillDto> billDto= (List<BillDto>) session.getAttribute("billDto");
        int idOrder= (int) session.getAttribute("idOrder");
        boolean success = true;
        for (BillDto bill: billDto){
            Book book= bookDetailDtoService.findBookById(bill.getIdBook());
            int quantity= bill.getQuantity();
            boolean flag= bookDetailDtoService.updateStock(book.getId(),quantity);
            if (!flag) {
                success =false;
                break;
            }

        }
        if (success) {
            session.setAttribute("message", "Điều chỉnh số lượng thành công");
            orderService.deleteById(idOrder);

        } else {
            session.setAttribute("message", "Điều chỉnh số lượng thất bại");
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/admin/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void approve(HttpServletRequest req, HttpServletResponse resp) {
        int idOrder = Integer.parseInt(req.getParameter("idOrder"));
//        int idCustomer = Integer.parseInt(req.getParameter("idCustomer"));
//        System.out.println("idOrder: " + idOrder + " idCustomer: " + idCustomer);
        List<BillDto> billDto = billDtoService.approve(idOrder);
        HttpSession session= req.getSession();
        session.setAttribute("billDto", billDto);
        session.setAttribute("idOrder", idOrder);
        try {
            resp.sendRedirect(req.getContextPath() + "/views/admin/order/approve.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void editOrder(HttpServletRequest req, HttpServletResponse resp) {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        System.out.println(idEdit);
        getInfoFromForm(req);
        Order order = getInfoFromForm(req);
        boolean isAdd = orderService.saveOrder(order, idEdit);
        HttpSession session = req.getSession();
        if (isAdd) {
            session.setAttribute("message", "Chỉnh sửa thành công");
        } else {
            session.setAttribute("message", "Chỉnh sửa thất bại");
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/admin/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Order getInfoFromForm(HttpServletRequest req) {
        Order order = new Order();
        order.setId_customer(Integer.parseInt(req.getParameter("id_customer")));
        order.setTotal(Integer.parseInt(req.getParameter("total")));
        order.setTime(Date.valueOf(req.getParameter("time")));
        order.setStatus(req.getParameter("status"));
        return order;
    }


    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        boolean isDelete = orderService.deleteById(id);
        HttpSession session = req.getSession();
        if (isDelete) {
            session.setAttribute("message", "Xóa đơn hàng thành công");
        } else {
            session.setAttribute("message", "Xóa đơn hàng thất bại");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/order");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Add order");
        Order order = getInfoFromForm(req);
        boolean isAdd = orderService.saveOrder(order);
        HttpSession session = req.getSession();
        if (isAdd) {
            session.setAttribute("message", "Tạo đơn hàng thành công");
        } else {
            session.setAttribute("message", " Tạo đơn hàng thất bại");
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/admin/order");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
