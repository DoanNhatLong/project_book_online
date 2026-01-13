<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<c:import url="../navbar.jsp"/>
<nav class="navbar bg-black " style="margin-top: 4rem; height: 3rem;">
    <div class="container d-flex  align-items-center" id="subNavbar">
        <div>
            <button class="btn btn-outline-light me-2"
                    id="tag_name"
                    data-bs-toggle="modal"
                    data-bs-target="#tag_modal"
                    aria-expanded="false"
            > Thể loại
            </button>
            <button class="btn btn-outline-light me-2"> Đề cử sách</button>
            <button class="btn btn-outline-light"> Thảo luận</button>
        </div>
        <div>
            <button class="btn btn-outline-light me-2"> Hướng dẫn</button>
            <button class="btn btn-outline-light"> Mua BP</button>
        </div>

    </div>

</nav>

</body>
</html>
