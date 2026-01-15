<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<c:import url="navbar.jsp"/>
<c:if test="${sessionScope.message != null}">
    <div class="toast-container position-fixed top-0 end-0 p-3">
        <div class="toast show" role="alert">
            <div class="toast-header">
                <strong class="me-auto text-primary">Thông báo</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
            </div>
            <div class="toast-body">
                    ${sessionScope.message}
            </div>
        </div>
    </div>
    <c:remove var="message" scope="session"/>
</c:if>

<nav class="navbar bg-black " style="margin-top: 4rem; height: 3rem;">
    <div class="container d-flex  align-items-center" id="subNavbar">
        <div>
            <button class="btn btn-outline-light me-2"
                    id="tag_name"
                    data-bs-toggle="modal"
                    data-bs-target="#tag_modal"
                    aria-expanded="false"
            > Thể loại
            </button>
            <a href="/clients?action=multiSearch" class="btn btn-outline-light me-2">Tìm kiếm nâng cao </a>
        </div>
        <div>
            <a href="/clients?action=buyPoint" class="btn btn-outline-warning"> Mua Point</a>
            <a href="/clients?action=logout" class="btn btn-outline-danger">Đăng xuất</a>
        </div>

    </div>

</nav>

<div class="container mt-1 mb-3" id="content1">
    <div class="row gx-4 align-items-stretch" style="height: 20rem;">
        <div class="col-2 d-flex flex-column gap-3">
            <div class="border rounded p-2 flex-fill d-flex flex-column justify-content-start">
                <h6 class="text-center">Top 3 sách mua tháng</h6>
                <ul class="list-group list-group-flush mt-2">
                    <li class="list-group-item">Sách 1</li>
                    <li class="list-group-item">Sách 2</li>
                    <li class="list-group-item">Sách 3</li>
                </ul>
            </div>
            <div class="border rounded p-2 flex-fill d-flex flex-column justify-content-start">
                <h6 class="text-center">Top 3 sách mua all </h6>
                <ul class="list-group list-group-flush mt-2">
                    <li class="list-group-item">Sách 1</li>
                    <li class="list-group-item">Sách 2</li>
                    <li class="list-group-item">Sách 3</li>
                </ul>
            </div>
        </div>

        <div class="col-8">
            <div id="carouselExampleCaptions" class="carousel slide h-100">
                <div class="carousel-inner h-100">
                    <div class="carousel-item active h-100">
                        <a href="/clients?action=book&id=3">
                            <img src="/image/b1.jpg" class="d-block w-100 h-100" alt="..."
                                 style="object-fit: cover;">
                        </a>
                    </div>
                    <div class="carousel-item h-100">
                        <a href="/clients?action=book&id=1">
                        <img src="/image/img%202.jpg" class="d-block w-100 h-100" alt="..."
                             style="object-fit: cover;">
                        </a>
                    </div>
                    <div class="carousel-item h-100">
                        <a href="/clients?action=book&id=4">
                        <img src="/image/item3.jpg" class="d-block w-100 h-100" alt="..."
                             style="object-fit: cover;">
                        </a>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>

        <div class="col-2 d-flex flex-column gap-3">
            <div class="border rounded p-2 flex-fill d-flex flex-column justify-content-start">
                <h6 class="text-center">Top 3 sách vừa mở khóa</h6>
                <ul class="list-group list-group-flush mt-2">
                    <li class="list-group-item">Sách 1</li>
                    <li class="list-group-item">Sách 2</li>
                    <li class="list-group-item">Sách 3</li>
                </ul>
            </div>
            <div class="border rounded p-2 flex-fill d-flex flex-column justify-content-start">
                <h6 class="text-center">Top 3 sách mở khóa all </h6>
                <ul class="list-group list-group-flush mt-2">
                    <li class="list-group-item">Sách 1</li>
                    <li class="list-group-item">Sách 2</li>
                    <li class="list-group-item">Sách 3</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container mt-4" style="overflow: visible; position: relative; z-index: 1;">

    <div class="d-flex overflow-auto gap-3 py-2" style="white-space: nowrap;margin-top: 9rem" >
        <c:forEach var="book" items="${sessionScope.initBookList}" begin="1" end="7">
            <a href="/clients?action=book&id=${book.id}" class="d-block flex-shrink-0" style="width: 10rem; ">
                <img src="/css/images.jpg"
                     class="img-fluid rounded"
                     style="height: 12rem; object-fit: cover;">
                <p class="text-center mt-1">${book.name}</p>
            </a>
        </c:forEach>
    </div>
</div>

<div class="container mt-4">
    <div class="row">
        <div class="col-md-4">
            <div class="card bg-light mb-3">
                <div class="card-header text-center">Tác giả yêu thích</div>
                <ul class="list-group list-group-flush">
                    <c:forEach var="i" begin="1" end="5">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span>${i}. Tên sách ${i}</span>
                            <span class="badge bg-primary rounded-pill">#</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-light mb-3">
                <div class="card-header text-center">Thể loại yêu thích</div>
                <ul class="list-group list-group-flush">
                    <c:forEach var="i" begin="1" end="5">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span>${i}. Tên sách ${i}</span>
                            <span class="badge bg-success rounded-pill">#</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card bg-light mb-3">
                <div class="card-header text-center">Sách đề cử</div>
                <ul class="list-group list-group-flush">
                    <c:forEach var="i" begin="1" end="5">
                        <li class="list-group-item d-flex justify-content-between align-items-center">
                            <span>${i}. Tên sách ${i}</span>
                            <span class="badge bg-warning rounded-pill">#</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>


<footer>
    <footer class="bg-light text-success mt-5">
        <div class="container py-4">
            <div class="row">

                <div class="col-md-4 mb-3">
                    <h5 class="text-uppercase">BookStore</h5>
                    <p class="small text-muted">
                        Nền tảng mua và đọc sách trực tuyến.
                        Khám phá tri thức, lưu giữ đam mê đọc sách mỗi ngày.
                    </p>
                </div>

                <div class="col-md-4 mb-3">
                    <h6 class="text-uppercase">Liên kết</h6>
                    <ul class="list-unstyled">
                        <li><a href="/clients" class="text-decoration-none text-primary">Trang chủ</a></li>
                        <li><a href="/clients?action=cart" class="text-decoration-none text-primary">Giỏ hàng</a></li>
                        <li><a href="/clients?action=info" class="text-decoration-none text-primary">Tài khoản</a></li>
                    </ul>
                </div>

                <div class="col-md-4 mb-3">
                    <h6 class="text-uppercase">Liên hệ</h6>
                    <p class="small mb-1">Email: support@bookstore.com</p>
                    <p class="small mb-1">Hotline: 0123 456 789</p>
                    <p class="small">© 2026 BookStore</p>
                </div>

            </div>
        </div>
    </footer>
</footer>





</body>
</html>
