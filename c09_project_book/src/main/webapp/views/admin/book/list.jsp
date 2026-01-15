<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <c:import url="../library-css.jsp"/>
    <c:import url="../admin-css.jsp"/>
</head>
<body>
<div class="d-flex">

    <!-- Sidebar -->
    <c:import url="../sidebar.jsp"/>

    <!-- Main content -->
    <div class="flex-grow-1 d-flex flex-column main-content">

    <!-- Header -->
        <c:import url="../header.jsp"/>

        <!-- Content -->
        <div class="container-fluid p-4 admin-content table-wrapper">


            <!-- Statistic -->
            <c:import url="../statistic.jsp"/>
            <!-- Table -->
            <div class="card shadow-sm mt-3 admin-table-card table-container">
                <div class="card-header bg-white py-2 d-flex justify-content-between align-items-center">
                    <h6 class="mb-0">Quản lý sách</h6>
                    <a href="/admin/book?action=add" class="btn btn-sm btn-success">
                        Thêm mới sách
                    </a>
                </div>
                <!-- TABLE SCROLL -->
                <div class="table-admin">
                    <table class="table table-hover table-sm align-middle mb-0">
                        <thead class="table-dark small sticky-top">
                        <tr>
                            <th>#</th>
                            <th>Ảnh</th>
                            <th>Tên sách</th>
                            <th class="text-end">Giá</th>
                            <th class="text-end">SL</th>
                            <th>Thể loại</th>
                            <th>Tác giả</th>
                            <th>Hành động</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>

                        <tbody class="small">
                        <c:forEach items="${bookList}" var="book" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>
                                    <img src="${book.imageUrl}"
                                         class="rounded"
                                         style="width:28px;height:22px;object-fit:cover;">
                                </td>
                                <td>${book.name}</td>
                                <td class="text-end">
                                    <fmt:formatNumber value="${book.price}"
                                                      type="number"
                                                      groupingUsed="true"
                                                      maxFractionDigits="0"/>
                                </td>
                                <td class="text-end">${book.stock}</td>
                                <td>${book.category}</td>
                                <td>${book.author}</td>
                                <td>
                                    <button data-bs-toggle="modal"
                                            data-bs-target="#exampleModal"
                                            onclick="showDataToModal('${book.id}')"
                                            class="btn btn-success btn-sm px-2 py-0">
                                        Thêm nội dung
                                    </button>
                                </td>
                                <td>
                                    <a href="/admin/book?action=read-book&id=${book.id}">Đọc sách</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>

</div>


<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/admin/book?action=add-content"
              method="post"
              enctype="multipart/form-data" >

            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title">Khoá tài khoản</h6>
                </div>
                <div class="modal-body">
                    <input name="id" id="id">
                    <input type="file" name="pdf-url" id="pdf-url">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-sm" data-bs-dismiss="modal">Huỷ</button>
                    <button type="submit" class="btn btn-danger btn-sm">Thêm nội dung</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--Bootstrap 5.2--%>

<script>
    function showDataToModal(id) {
        document.getElementById("id").value = id;
    }
</script>
<c:import url="../library-js.jsp"/>
</body>
</html>
