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
    <div class="flex-grow-1">
        <!-- Header -->
        <c:import url="../header.jsp"/>

        <!-- Content -->
        <div class="container-fluid p-4">

            <!-- Statistic -->
            <c:import url="../statistic.jsp"/>

            <!-- Table -->
            <div class="card shadow-sm mt-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <h5 class="mb-3">Quản lý sách</h5>
                        <c:if test="${param.mess == 'true'}">
                            <div class="alert alert-success text-danger py-0">Cập nhật trạng thái thành công</div>
                        </c:if>
                        <c:if test="${param.mess == 'false'}">
                            <div class="alert alert-danger text-danger py-0">Cập nhật thất bại</div>
                        </c:if>
                        <a href="/admin/book?action=add" class="btn btn-sm btn-success" >Thêm mới sách</a>
                    </div>
                    <table class="table table-hover">
                        <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>Hìn ảnh</th>
                            <th>Tên sách</th>
                            <th>Giá (VNĐ)</th>
                            <th>Số lượng</th>
                            <th>Thể loại</th>
                            <th>Tác giả</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bookList}" var="book" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>
                                    <img width="30" src="${book.imageUrl}">
                                </td>
                                <td>${book.name}</td>

                                <td class="text-end">
                                    <fmt:formatNumber value="${book.price}" type="number" groupingUsed="true"
                                                      maxFractionDigits="0"/>
                                </td>

                                <td class="text-end">${book.stock}</td>

                                <td>${book.category}</td>
                                <td>${book.author}</td>
                                <td></td>
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
        <form action="/admin/books" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title">Khoá tài khoản</h6>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="username" id="username">
                    <input type="hidden" name="action" id="action">
                    <span>Bạn có chắc chắn <span class="text-danger" id="action-display"></span> tài khoản </span><span
                        class="text-danger" id="username-display"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-sm" data-bs-dismiss="modal">Không</button>
                    <button type="submit" class="btn btn-danger btn-sm">Có</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--Bootstrap 5.2--%>

<script>
    function updateAccount(username, action) {
        alert(username + action);
        document.getElementById("username").value = username;
        document.getElementById("username-display").innerHTML = username;
        document.getElementById("action").value = action;
        (action == "lock") ? action = "Khoá" : action = "Mở";
        document.getElementById("action-display").innerHTML = action;
    }
</script>
<c:import url="../library-js.jsp"/>
</body>
</html>
