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
                    <h5 class="mb-3">Quản lý đơn hàng</h5>

                    <table class="table table-hover">
                        <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>Tên sách</th>
                            <th>Tác giả</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Sách 1</td>
                            <td>Tác giả A</td>
                            <td>
                                <a href="#" class="btn btn-sm btn-success">Sửa</a>
                                <a href="#" class="btn btn-sm btn-danger">Xóa</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </div>

</div>

</body>
</html>
