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
            <button class="btn btn-outline-light me-2"> Đề cử sách</button>
            <button class="btn btn-outline-light"> Thảo luận</button>
        </div>
        <div>
            <button class="btn btn-outline-light me-2"> Hướng dẫn</button>
            <button class="btn btn-outline-light"> Mua BP</button>
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
                        <img src="/image/b1.jpg" class="d-block w-100 h-100" alt="..."
                             style="object-fit: cover;">
                    </div>
                    <div class="carousel-item h-100">
                        <img src="/css/images.jpg" class="d-block w-100 h-100" alt="..."
                             style="object-fit: cover;">
                    </div>
                    <div class="carousel-item h-100">
                        <img src="/css/images.jpg" class="d-block w-100 h-100" alt="..."
                             style="object-fit: cover;">
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
    <h5>Danh sách nổi bật</h5>
    <div class="d-flex overflow-auto gap-3 py-2" style="white-space: nowrap;">
        <c:forEach var="i" begin="1" end="10">
            <a href="/clients?action=book&id=${i}" class="d-block flex-shrink-0" style="width: 10rem;">
                <img src="/css/images.jpg"
                     class="img-fluid rounded"
                     alt="Sách ${i}"
                     style="height: 12rem; object-fit: cover;">
                <p class="text-center mt-1">Tên sách ${i}</p>
            </a>
        </c:forEach>
    </div>
</div>



</body>
</html>
