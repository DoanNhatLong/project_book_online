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
<c:import url="../library-js.jsp"/>
</body>
</html>
