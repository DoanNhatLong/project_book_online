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
</head>
<body>
<main>
    <nav class="navbar bg-light fixed-top d-flex align-items-center ">
        <div class="container d-flex align-items-center" id="mainNavbar">
            <a href="/" class="btn btn-success">
                Trang chủ
            </a>
            <form class="mx-auto d-flex align-items-center h-100" role="search">
                <input class="form-control me-2"
                       type="search"
                       placeholder=" Tìm sách, tác giả ..."
                       aria-label="Search"
                       style="width: 30rem;">
            </form>

            <div class="ms-auto d-flex align-items-center g-2">
                <div class="dropdown">
                    <button class="btn p-0 border-0 bg-transparent me-3"
                            type="button"
                            id="MenuButton1"
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
                    <button
                            class="btn p-0 border-0 bg-transparent me-3"
                            data-bs-toggle="modal"
                            data-bs-target="#historyModal"
                            style="font-size: 1.6rem"
                            title="Tủ sách"
                    >
                        📖
                    </button>

                    <button class="btn p-0 border-0 bg-transparent me-3"
                            type="button"
                            id="menuButton2"
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
                        <button class="dropdown-item">Chi tiết tài khoản</button>
                        <button class="dropdown-item">Mua BP</button>
                        <button class="dropdown-item text-danger"> Đăng xuất</button>
                    </div>
                </div>
            </div>
        </div>


    </nav>
    <nav class="navbar bg-black" style="margin-top: 4rem; height: 3rem;">
        <div class="container d-flex  align-items-center" id="subNavbar">
            <div>
                <button class="btn btn-outline-light me-2"
                        id="tag_name"
                        data-bs-toggle="modal"
                        data-bs-target="#tag_modal"
                        aria-expanded="false"
                > Thể loại
                </button>
                <button class="btn btn-outline-light me-2"> Đề cử sách</button>
                <button class="btn btn-outline-light"> Thảo luận</button>
            </div>
            <div>
                <button class="btn btn-outline-light me-2"> Hướng dẫn</button>
                <button class="btn btn-outline-light"> Mua BP</button>
            </div>

        </div>

    </nav>
    <div class="container mt-1" id="content1">
        <div class="row gx-4">
            <div class="col-3 bg-primary">
                <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquam aliquid amet at consequatur
                    culpa, deleniti odio quaerat rerum voluptatum!</p>
            </div>
            <div class="col-6">
                <div id="carouselExampleCaptions" class="carousel slide" style="">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/css/images.jpg" class="d-block " alt="..."
                                 style="width: 40rem; margin: auto; height: auto;">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>First slide label</h5>
                                <p>Some representative placeholder content for the first slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/css/images.jpg" class="d-block " alt="..."
                                 style="width: 40rem; margin: auto; height: auto;">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Second slide label</h5>
                                <p>Some representative placeholder content for the second slide.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="/css/images.jpg" class="d-block " alt="..."
                                 style="width: 40rem; margin: auto; height: auto;">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Third slide label</h5>
                                <p>Some representative placeholder content for the third slide.</p>
                            </div>
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
            <div class="col-3 bg-secondary">
                <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium ad aut expedita iure minus
                    molestias placeat possimus, reprehenderit sunt voluptates.</p>
            </div>
        </div>
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
                        <a href="/" class="btn btn-outline-primary w-100">Thể loại 1</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/" class="btn btn-outline-primary w-100">Thể loại 2</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/" class="btn btn-outline-primary w-100">Thể loại 3</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/" class="btn btn-outline-primary w-100">Thể loại 4</a>
                    </div>
                    <div class="col-md-4">
                        <a href="/" class="btn btn-outline-primary w-100">Thể loại 5</a>
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
