<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/13/2026
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
  <c:import url="/views/library.jsp"/>
</head>
<body>
<%------Test lỗi -----%>
<%--<button class="btn p-0 border-0 bg-transparent me-3 position-relative"--%>
<%--        type="button"--%>
<%--        id="menuButton2"--%>
<%--        title="Tài khoản"--%>
<%--        data-bs-toggle="dropdown"--%>
<%--        aria-expanded="false"--%>
<%--        style="font-size: 1.6rem">--%>
<%--  👤--%>
<%--</button>--%>
<%--<div class="dropdown-menu">--%>
<%--  <div class="dropdown-header">--%>
<%--    <p> User</p>--%>
<%--    <p> Số BP còn lại </p>--%>
<%--  </div>--%>
<%--  <a href="/clients?action=info" class="btn dropdown-item">Chi tiết tài khoản</a>--%>
<%--  <button class="dropdown-item">Mua BP</button>--%>
<%--  <a href="/login" class=" btn dropdown-item text-success"> Đăng nhập </a>--%>
<%--  <a href="/login" class=" btn dropdown-item text-danger"> Đăng xuất</a>--%>
<%--</div>--%>


<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
  <div class="card shadow p-4" style="width: 400px;">
    <h3 class="text-center mb-4">Đăng nhập</h3>

    <c:if test="${not empty error}">
      <div class="alert alert-danger">
          ${error}
      </div>
    </c:if>

    <form action="/login" method="post">
      <div class="mb-3">
        <label for="username" class="form-label">Tên đăng nhập</label>
        <input type="text" class="form-control" id="username" name="username" required>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">Mật khẩu</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>

      <div class="d-grid gap-2">
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
        <a href="/register" class="btn btn-secondary">Đăng ký</a>
      </div>
    </form>
  </div>
</div>

</body>
</html>
