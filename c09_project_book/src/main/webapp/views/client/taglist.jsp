<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<h2> Test</h2>
<%@ page contentType="text/html;charset=UTF-8" %>


<html>
<head>
    <title>Tag list</title>
    <style>
        .book-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
            gap: 16px;
            padding: 20px;
        }

        .book-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 12px;
            background: #fff;
            text-decoration: none;
            color: #000;
            transition: 0.2s;
        }

        .book-card:hover {
            box-shadow: 0 4px 10px rgba(0,0,0,0.15);
            transform: translateY(-3px);
        }

        .book-title {
            font-weight: bold;
            font-size: 16px;
            margin-bottom: 6px;
        }

        .book-author {
            font-size: 14px;
            color: #666;
        }

        .book-price {
            margin-top: 10px;
            color: #d32f2f;
            font-weight: bold;
        }
    </style>
</head>

<body>
<c:import url="../navbar.jsp"/>

<div class="container book-list pt-5">
    <c:forEach items="${list_book}" var="book">
        <a class="book-card"
           href="/clients?action=book&id=${book.id}">

            <div class="book-title">
                    ${book.name}
            </div>

            <div class="book-author">
                Tác giả: ${book.authorName}
            </div>

            <div class="book-price">
                    ${book.price} ₫
            </div>
        </a>
    </c:forEach>
</div>

</body>
</html>



</body>
</html>
