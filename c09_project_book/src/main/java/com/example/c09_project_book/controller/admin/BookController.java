package com.example.c09_project_book.controller.admin;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.c09_project_book.dto.BookDetailDto;
import com.example.c09_project_book.entity.Book;
import com.example.c09_project_book.service.BookDetailDtoService;
import com.example.c09_project_book.service.CategoryService;
import com.example.c09_project_book.service.IBookDetailDtoService;
import com.example.c09_project_book.service.ICategoryService;
import com.example.c09_project_book.utils.CloudinaryUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BookController", value = "/admin/book")
@MultipartConfig
public class BookController extends HttpServlet {
    private IBookDetailDtoService bookDetailDtoService = new BookDetailDtoService();
    private ICategoryService categoryService = new CategoryService();

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
            case "read-book":
                // trả về trang thêm mới
                readBook(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }

    }


    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("categoryList", categoryService.findAll());
        request.getRequestDispatcher("/views/admin/book/add.jsp").forward(request, response);
    }

    private void readBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));

        Book book = bookDetailDtoService.findById(bookId);
        req.setAttribute("book",book);
        req.setAttribute("pdfUrl",book.getPdfUrl());
        try {
            req.getRequestDispatcher("/views/admin/book/read.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

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
            case "add-content":
                // trả về trang thêm mới
                addContent(req, resp);
                break;
            default:
                break;
        }
    }



    private void addContent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Part filePart = req.getPart("pdf-url");
        // 1. Lưu file tạm
        String fileName = "book_" + id + ".pdf";
        File tempFile = File.createTempFile("upload_", fileName);

        try (InputStream in = filePart.getInputStream();
             FileOutputStream out = new FileOutputStream(tempFile)) {
            in.transferTo(out);
        }
//         2. Upload lên Cloudinary
        Cloudinary cloudinary = CloudinaryUtil.getCloudinary();
        Map uploadResult = cloudinary.uploader().upload(
                tempFile,
                ObjectUtils.asMap(
                        "resource_type", "raw",
                        "public_id", "book-manager/book/book_" + id,
                        "overwrite", true
                )
        );
        // 3. Xóa file tạm
        tempFile.delete();
        String pdfUrl = uploadResult.get("secure_url").toString();
        System.out.println("---------------------------------------");
        System.out.println(pdfUrl);

        boolean isSuccess = bookDetailDtoService.addContent(id, pdfUrl);
        resp.sendRedirect(req.getContextPath() + "/admin/book?mess=" + isSuccess);

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
        Book book = new Book(name, price, stock, desc, imageUrl, author, categoryId);
        boolean isSuccess = bookDetailDtoService.add(book);
        try {
            resp.sendRedirect(req.getContextPath() + "/admin/book?mess=" + isSuccess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
