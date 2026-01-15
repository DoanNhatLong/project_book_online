<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                        <h5 class="mb-3">Quản lý tài khoản người dùng</h5>

                        <c:if test="${param.mess == 'true'}">
                            <div class="alert alert-success text-danger py-0">Cập nhật trạng thái thành công</div>
                        </c:if>
                        <c:if test="${param.mess == 'false'}">
                            <div class="alert alert-danger text-danger py-0">Cập nhật thất bại</div>
                        </c:if>
                    </div>
                    <table class="table table-hover table-sm align-middle mb-0">
                        <thead class="table-dark small">
                        <tr>
                            <th style="width:40px">#</th>
                            <th>Username</th>
                            <th style="width:100px">Role</th>
                            <th style="width:120px">Hành động</th>
                        </tr>
                        </thead>
                        <tbody class="small">
                        <c:forEach items="${accountList}" var="book" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${book.username}</td>
                                <td>
                                    <span class="badge bg-secondary">${book.role}</span>
                                </td>
                                <td>
                                    <c:if test="${book.isLocked()}">
                                        <button data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                onclick="updateAccount('${book.username}','unlock')"
                                                class="btn btn-danger btn-sm px-2 py-0">
                                            Khoá
                                        </button>
                                    </c:if>

                                    <c:if test="${!book.isLocked()}">
                                        <button data-bs-toggle="modal"
                                                data-bs-target="#exampleModal"
                                                onclick="updateAccount('${book.username}','lock')"
                                                class="btn btn-success btn-sm px-2 py-0">
                                            Hoạt động
                                        </button>
                                    </c:if>
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
        <form action="/admin/account" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title">Khoá tài khoản</h6>
            </div>
            <div class="modal-body">
                <input type="hidden" name="username" id="username">
                <input type="hidden" name="action" id="action">
                <span>Bạn có chắc chắn <span class="text-danger" id="action-display"></span> tài khoản </span><span class="text-danger" id="username-display"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-sm" data-bs-dismiss="modal">Không</button>
                <button type="submit" class="btn btn-danger btn-sm">Có</button>
            </div>
        </div>
        </form>
    </div>
</div>
<script>
    function updateAccount(username,action){
        document.getElementById("username").value = username;
        document.getElementById("username-display").innerHTML = username;
        document.getElementById("action").value = action;
        (action=="lock")? action="Khoá":action="Mở";
        document.getElementById("action-display").innerHTML = action;
    }
</script>
<c:import url="../library-js.jsp"/>
</body>
</html>
