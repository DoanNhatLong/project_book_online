package com.example.c09_project_book.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;
import com.example.c09_project_book.service.BookDetailDtoService;
import com.example.c09_project_book.service.IBookDetailDtoService;
import com.example.c09_project_book.utils.CloudinaryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookController", value = "/admin/book")
@MultipartConfig
public class BookController extends HttpServlet {
    private IBookDetailDtoService bookDetailDtoService = new BookDetailDtoService();

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
            default:
                showList(req, resp);
                break;
        }

    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getRequestDispatcher("/views/admin/book/add.jsp").forward(request,response);
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
            case "add":
                save(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("image-url");

        byte[] fileBytes = filePart.getInputStream().readAllBytes();

        Cloudinary cloudinary = CloudinaryUtil.getCloudinary();

        Map uploadResult = cloudinary.uploader().upload(
                fileBytes,
                ObjectUtils.asMap(
                        "folder", "book-manager/book"
                )
        );
        // đường dẫn từ cloudary
        String imageUrl = uploadResult.get("secure_url").toString();

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        int categoryId = Integer.parseInt(req.getParameter("category-id"));
        String author = req.getParameter("author");
        String desc = req.getParameter("desc");
        Book book = new Book(name,price,stock,desc,imageUrl,author,categoryId);
        boolean isSuccess = bookDetailDtoService.add(book);
        resp.sendRedirect("/admin/book");
    }
}
