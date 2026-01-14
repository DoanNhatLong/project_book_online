<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chapter</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<c:if test="${sessionScope.message != null}">
    <div class="toast-container position-fixed top-0 end-0 p-3">
        <div class="toast show" role="alert">
            <div class="toast-header">
                <strong class="me-auto text-primary">Thông báo</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast"></button>
            </div>
            <div class="toast-body">
                    ${sessionScope.message}
            </div>
        </div>
    </div>
    <c:remove var="message" scope="session"/>
</c:if>


<div class="container mt-4">
    <h4 class="mb-3">Mục lục</h4>

    <ul class="list-group">
        <c:forEach var="i" begin="1" end="${sessionScope.chapter.chapter_unlock}">
            <li class="list-group-item d-flex justify-content-between align-items-center">

                <span>Chương ${i}</span>

                <c:choose>

                    <c:when test="${i <= sessionScope.openChapter}">
                        <a href="/clients?action=readChapter&chapter=${i}&bookName=${sessionScope.chapter.name}"
                           class="btn btn-sm btn-success">
                            Đọc
                        </a>
                    </c:when>

                    <c:when test="${i == sessionScope.openChapter + 1}">
                        <button class="btn btn-sm btn-outline-primary"
                                data-bs-toggle="modal"
                                data-bs-target="#unlockModal${i}">
                            🔓 Mở khóa (${sessionScope.chapter.point} point)
                        </button>
                    </c:when>

                    <c:otherwise>
                        <button class="btn btn-sm btn-outline-secondary" disabled>
                            🔒 Chưa thể mở
                        </button>
                    </c:otherwise>

                </c:choose>

            </li>
        </c:forEach>
    </ul>
</div>

<c:forEach var="i" begin="1" end="${sessionScope.chapter.chapter_unlock}">
    <div class="modal fade" id="unlockModal${i}" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title">Mở khóa chương ${i}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
                    <c:choose>
                        <c:when test="${empty sessionScope.account}">
                            <div class="text-danger">
                                Vui lòng đăng nhập để mở khóa chương
                            </div>
                        </c:when>
                        <c:otherwise>
                            Bạn có chắc muốn mở khóa chương ${i} với
                            <strong>${sessionScope.chapter.point}</strong> point?
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-secondary" data-bs-dismiss="modal">
                        Hủy
                    </button>

                    <c:if test="${not empty sessionScope.account}">
                        <form action="/clients" method="post">
                            <input type="hidden" name="action" value="unlockChapter">
                            <input type="hidden" name="chapter" value="${i}">
                            <button type="submit" class="btn btn-primary">
                                Xác nhận
                            </button>
                        </form>
                    </c:if>
                </div>

            </div>
        </div>
    </div>
</c:forEach>

</body>
</html>
