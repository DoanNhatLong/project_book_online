<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tìm kiếm sách</title>
    <c:import url="/views/library.jsp"/>
</head>

<body>
<c:import url="/views/navbar.jsp"/>

<div class="container" style="margin-top: 9rem">

    <div class="card mb-4 shadow-sm">
        <div class="card-header fw-semibold">
            Tìm kiếm nâng cao
        </div>
        <div class="card-body">
            <form method="post" action="/clients?aciton=multiSeach">
                <input type="hidden" name="action" value="multiSearch">

                <div class="row g-3">
                    <div class="col-md-4">
                        <input type="text"
                               name="author"
                               class="form-control"
                               placeholder="Tác giả"
                               value="${author}">
                    </div>

                    <div class="col-md-4">
                        <input type="text"
                               name="bookName"
                               class="form-control"
                               placeholder="Tên sách"
                               value="${bookName}">
                    </div>

                    <div class="col-md-4">
                        <input type="number"
                               name="price"
                               class="form-control"
                               placeholder="Giá tối đa"
                               value="${price}">
                    </div>


                </div>

                <div class="text-end mt-3">
                    <button class="btn btn-primary">
                        Tìm kiếm
                    </button>
                </div>
            </form>
        </div>
    </div>

    <c:set var="pageSize" value="10"/>
    <c:set var="currentPage" value="${empty param.page ? 1 : param.page}"/>
    <c:set var="start" value="${(currentPage - 1) * pageSize}"/>
    <c:set var="end" value="${start + pageSize - 1}"/>
    <c:set var="totalPage" value="${(list_book.size() + pageSize - 1) / pageSize}"/>

    <div class="card shadow-sm">
        <div class="card-body">

            <c:if test="${empty list_book}">
                <div class="text-center text-muted">
                    Không tìm thấy sách phù hợp
                </div>
            </c:if>

            <ul class="list-group list-group-flush">
                <c:forEach var="book"
                           items="${list_book}"
                           begin="${start}"
                           end="${end}">
                    <li class="list-group-item">
                        <a href="/clients?action=book&id=${book.id}"
                           class="text-decoration-none fw-semibold">
                                ${book.name}
                        </a>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>

    <c:if test="${totalPage > 1}">
        <nav class="mt-4">
            <ul class="pagination justify-content-center">
                <c:forEach var="i" begin="1" end="${totalPage}">
                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                        <a class="page-link"
                           href="/clients?action=multiSearch&page=${i}">
                                ${i}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </c:if>

</div>

</body>
</html>
