<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/views/library.jsp"/>
</head>
<style>
    .dropdown-toggle::after {
        display: none !important;
    }
</style>
<body>
<main>
    <nav class="navbar navbar-light bg-light fixed-top ">
        <div class="container d-flex align-items-center" id="mainNavbar">
            <a href="/home" class="btn btn-success">
                Trang chủ
            </a>
            <form class="mx-auto d-flex align-items-center h-100" role="search" method="post" action="/clients?action=searchBook">
                <input class="form-control me-2"
                       type="search"
                       name="keyword"
                       placeholder="Tìm sách ..."
                       aria-label="Search"
                       style="width: 30rem;"
                       required>
                <input type="hidden" name="action" value="searchBook">
            </form >
            <div class="ms-auto me-3 d-flex align-items-center">
                <div class="px-3 py-1 rounded-pill bg-warning bg-opacity-25 d-flex align-items-center">
                    <span class="me-1">💎</span>
                    <span class="fw-semibold me-1">Point</span>
                    <span class="fw-bold text-danger">
                        ${sessionScope.pointOfAccount}
                    </span>
                </div>
            </div>

            <div class="ms-auto d-flex align-items-center g-2">
                <a href="/clients?action=cart"
                   class="btn p-0 border-0 bg-transparent me-3 position-relative"
                   style="font-size: 1.6rem;"
                   title="Giỏ hàng">
                    🛒
                </a>

                <button
                        class="btn p-0 border-0 bg-transparent me-3 position-relative"
                        style="font-size: 1.6rem;"
                        data-bs-toggle="modal"
                        data-bs-target="#historyModal"
                >
                    📖
                </button>
                <div class="dropdown me-3">
                    <button class="btn p-0 border-0 bg-transparent dropdown-toggle"
                            type="button"
                            id="menuButton2"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            style="font-size: 1.6rem">
                        👤
                    </button>

                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a href="/clients?action=info" class="dropdown-item">Chi tiết tài khoản</a></li>
                        <li><a href="/login" class="dropdown-item text-success">Đăng nhập</a></li>
                        <li><a href="/login" class="dropdown-item text-danger">Đăng xuất</a></li>
                    </ul>
                </div>

            </div>

        </div>
    </nav>
    <div class="container-fluid">

    </div>

</main>

<div class="modal" id="tag_modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Chọn thể loại</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row g-3">
                    <div class="col-md-4">
                        <a href="/clients?action=taglist&tag=1" class="btn btn-outline-primary w-100">Lịch sử</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/clients?action=taglist&tag=2" class="btn btn-outline-primary w-100">Kinh điển</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/clients?action=taglist&tag=3" class="btn btn-outline-primary w-100">Kiếm hiệp</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/clients?action=taglist&tag=4" class="btn btn-outline-primary w-100">Phiêu Lưu</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/clients?action=taglist&tag=5" class="btn btn-outline-primary w-100">Tiên hiệp</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="historyModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">Lịch sử mua sách</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <div class="border rounded p-3">

                    <h6 class="text-center mb-3">Sách đã mua</h6>

                    <c:choose>
                        <c:when test="${empty historyList}">
                            <p class="text-center text-muted">Chưa có lịch sử mua sách</p>
                        </c:when>

                        <c:otherwise>
                            <table class="table table-sm table-striped">
                                <thead>
                                <tr>
                                    <th>Tên sách</th>
                                    <th>Thời gian mua</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${historyList}" var="h">
                                    <tr>
                                        <td>${h.bookName}</td>
                                        <td>
                                            <fmt:formatDate value="${h.buyTime}" pattern="dd/MM/yyyy HH:mm"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
