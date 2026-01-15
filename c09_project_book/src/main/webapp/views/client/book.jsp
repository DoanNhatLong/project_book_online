<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<c:import url="../navbar.jsp"/>
<div class="container " style="margin-top: 6rem">
    <div class="card mb-5 shadow-sm">
        <div class="row g-0">
            <div class="col-md-4 d-flex justify-content-center align-items-center p-3">
                <img src="${book.imageUrl}" class="img-fluid rounded" alt="${book.name}" style="max-height: 300px;">
            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h3 class="card-title">${book.name}</h3>
                    <p class="mb-1"><strong>Tác giả:</strong> ${book.author}</p>
                    <p class="mb-1"><strong>Thể loại:</strong> ${book.category}</p>
                    <p class="mb-1"><strong>Giá:</strong> ${book.price} VND</p>
                    <p class="mb-1"><strong>Kho:</strong> ${book.stock} cuốn</p>
                    <hr>
                    <h5>Mô tả:</h5>
                    <div class="border p-2 mb-3" style="max-height: 300px; overflow-y: auto;">
                        ${book.desc}
                    </div>
                    <div class="d-flex gap-2">
                        <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#buyModal">
                            Mua sách
                        </button>
                        <a href="/clients?action=read&id=${book.id}" class="btn btn-primary">Mở chương</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="buyModal" tabindex="-1" aria-labelledby="buyModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/clients" method="get" class="modal-content">
            <input type="hidden" name="action" value="cart">
            <div class="modal-header">
                <h5 class="modal-title" id="buyModalLabel">Chọn số lượng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id" value="${book.id}">
                <div class="mb-3">
                    <label for="quantity" class="form-label">Số lượng:</label>
                    <input type="number" name="quantity" id="quantity" class="form-control" value="1" min="1" max="${book.stock}" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success">Thêm vào giỏ hàng</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
