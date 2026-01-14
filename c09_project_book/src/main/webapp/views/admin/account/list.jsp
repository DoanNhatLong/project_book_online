<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>

    <!-- Bootstrap 5.2 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>


    <style>
        body {
            background-color: #f4f6f9;
        }

        .sidebar {
            width: 260px;
            min-height: 100vh;
            background: linear-gradient(180deg, #0f2027, #203a43, #2c5364);
        }

        .sidebar h4 {
            color: #7CFF6B;
        }

        .sidebar a {
            color: #e0e0e0;
            text-decoration: none;
            padding: 8px 16px;
            border-radius: 8px;
            margin: 6px 0;
            line-height: 1.2;
            font-size: 15px;
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .sidebar a:hover,
        .sidebar a.active {
            background-color: #198754;
            color: #fff;
        }

        .admin-header {
            background: #000;
            color: #7CFF6B;
            padding: 15px 20px;
            font-size: 18px;
            font-weight: bold;
        }

        .card {
            border-radius: 12px;
        }
    </style>
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
                    <h5 class="mb-3">Quản lý tài khoản người dùng</h5>

                    <table class="table table-hover">
                        <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>Role</th>
                            <th>Hành động</th>
<%--                            <th>Hành động</th>--%>
                        </tr>
                        </thead>
                        <tbody>
                         <c:forEach items="${accountList}" var="account" varStatus="status">
                             <tr>
                                 <td>${status.count}</td>
                                 <td>${account.username}</td>
                                 <td>${account.role}</td>
                                 <td>
                                     ${account.isLocked()}
                                     <c:if test="${account.isLocked()}">
                                         <button data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="updateAccount('${account.username}','lock')" class="btn btn btn-danger btn-sm">Đã khoá</button>
                                     </c:if>
                                     <c:if test="${!account.isLocked()}">
                                         <button data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="updateAccount('${account.username}','unlock')" class="btn btn btn-success btn-sm">Hoạt động</button>
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
        <form action="/admin/accounts" method="post">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Khoá tài khoản</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="username" id="username">
                <input type="hidden" name="action" id="action">
                <span>Bạn có chắc chắn <span class="text-danger" id="action-display"></span> tài khoản </span><span class="text-danger" id="username-display"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                <button type="button" class="btn btn-primary">Có</button>
            </div>
        </div>
        </form>
    </div>
</div>
<script>
    function updateAccount(username,action){
        alert(username + action);
        document.getElementById("username").value = username;
        document.getElementById("username-display").innerHTML = username;
        document.getElementById("action").value = action;
        (action=="lock")? action="Khoá":action="Mở";
        document.getElementById("action-display").innerHTML = action;
    }
</script>
</body>
</html>
