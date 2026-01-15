<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/15/2026
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<c:import url="/views/navbar.jsp"/>
<div class="container pt-5">
    <form action="/clients?action=gainpoint" method="post" class="card-body">
        <div class="mb-3">
            <label class="form-label">Số tiền (VNĐ)</label>
            <input type="number"
                   class="form-control"
                   id="money"
                   placeholder="Nhập số tiền"
                   min="0"
                   oninput="calculatePoint()">
        </div>

        <div class="mb-3">
            <label class="form-label">Số tài khoản</label>
            <input type="text" class="form-control" required>
        </div>

        <div class="alert alert-info">
            Point nhận được:
            <span class="fw-bold" id="pointText">0</span>
        </div>

        <input type="hidden" name="point" id="pointInput">

        <button class="btn btn-primary w-100">
            Xác nhận mua
        </button>
    </form>
</div>


<script>
    function calculatePoint() {
        const money = parseInt(document.getElementById("money").value) || 0;

        let point = money * 0.01;

        if (money > 100000) {
            point += point * 0.15;
        }

        point = Math.floor(point);

        document.getElementById("pointText").innerText = point;
        document.getElementById("pointInput").value = point;
    }
</script>

</body>
</html>
