<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            </form>

            <div class="ms-auto d-flex align-items-center g-2">

                <button class="btn p-0 border-0 bg-transparent me-3 position-relative"
                        type="button"
                        id="menuButton2"
                        title="Tài khoản"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                        style="font-size: 1.6rem">
                    👤
                </button>
                <div class="dropdown-menu">
                    <div class="dropdown-header">
                        <p> User</p>
                        <p> Số BP còn lại </p>
                    </div>
                    <a href="/clients?action=info" class="btn dropdown-item">Chi tiết tài khoản</a>
                    <button class="dropdown-item">Mua BP</button>
                    <a href="/login" class=" btn dropdown-item text-success"> Đăng nhập </a>
                    <a href="/login" class=" btn dropdown-item text-danger"> Đăng xuất</a>
                </div>
                <button class="btn p-0 border-0 bg-transparent me-3"
                        type="button"
                        id="MenuButton1"
                        title="Thông báo"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                        style="font-size: 1.6rem">
                    🔔
                </button>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li class="dropdown-header"> Thông báo</li>
                    <li><a class="dropdown-item" href="#">Bạn có đơn hàng mới</a></li>
                    <li><a class="dropdown-item" href="#">Khuyến mãi hôm nay</a></li>
                    <li><a class="dropdown-item text-center" href="#">Xem tất cả</a></li>
                </ul>
                <a href="/clients?action=cart"
                   class="btn p-0 border-0 bg-transparent me-3 position-relative"
                   style="font-size: 1.6rem;"
                   title="Giỏ hàng">
                    🛒
                </a>

                <button
                        class="btn p-0 border-0 bg-transparent me-3"
                        data-bs-toggle="modal"
                        data-bs-target="#historyModal"
                        style="font-size: 1.6rem"
                        title="Tủ sách"
                >
                    📖
                </button>

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
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Lịch sử đọc</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="row">

                    <div class="col-md-4">
                        <div class="border rounded p-3 h-100">
                            <h6 class="text-center">Chương đã mở</h6>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="border rounded p-3 h-100">
                            <h6 class="text-center">Sách đã mua</h6>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="border rounded p-3 h-100">
                            <h6 class="text-center">Lịch sử mua BP</h6>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
