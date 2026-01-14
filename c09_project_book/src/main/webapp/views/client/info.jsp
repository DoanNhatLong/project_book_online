<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/13/2026
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<div class="container mt-5">
    <c:import url="/views/navbar.jsp"/>

    <div class="card shadow-sm mx-auto" style="max-width: 600px;margin-top: 6rem">
        <div class="card-body">
            <h5 class="card-title text-center mb-4">${sessionScope.userInfo.name}</h5>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><strong>ID Account:</strong> ${sessionScope.userInfo.id_account}</li>
                <li class="list-group-item"><strong>Email:</strong> ${sessionScope.userInfo.email}</li>
                <li class="list-group-item"><strong>Phone:</strong> ${sessionScope.userInfo.phone}</li>
                <li class="list-group-item"><strong>Points:</strong> ${sessionScope.userInfo.point}</li>
            </ul>
        </div>
    </div>
</div>


</body>
</html>
