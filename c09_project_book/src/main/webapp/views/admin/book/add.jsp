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
                        <h5 class="mb-3">Thêm mới sách</h5>
<%--                        <c:if test="${param.mess == 'true'}">--%>
<%--                            <div class="alert alert-success text-danger py-0">Cập nhật trạng thái thành công</div>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${param.mess == 'false'}">--%>
<%--                            <div class="alert alert-danger text-danger py-0">Cập nhật thất bại</div>--%>
<%--                        </c:if>--%>
                    </div>
                    <form action="/admin/book?action=add" method="post" enctype="multipart/form-data">
                       Name: <input type="text" name="name" required />
                       Price: <input type="text" name="price" required />
                       Stock: <input type="number" name="stock" value="1" required />
                        Desc:  <textarea name="desc" required ></textarea>
                       Categoryr: <select name="category-id">
                            <option>---Chọn thể loại---</option>
                            <option value="1">Tiểu thuyết</option>
                            <option value="2">Trinh Thám</option>
                        </select>
                       Author: <input type="text" name="author"/>
                       Image <input type="file" name="image-url" required />
                        <button type="submit">Upload</button>
                    </form>

                </div>
            </div>

        </div>
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
