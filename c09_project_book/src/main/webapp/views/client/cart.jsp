<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/12/2026
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/views/library.jsp"/>
</head>
<body>
<h2>Cart</h2>

    <div class="container pt-5">
        <h2 class="mb-4">Giỏ hàng của bạn</h2>

        <c:choose>
            <c:when test="${empty sessionScope.cart}">
                <p>Giỏ hàng trống.</p>
            </c:when>
            <c:otherwise>
                <form action="/clients?action=updateCart" method="post">
                    <div class="table-responsive">
                        <table class="table table-striped align-middle">
                            <thead>
                            <tr>
                                <th scope="col">Tên sách</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Đơn giá (VND)</th>
                                <th scope="col">Thành tiền (VND)</th>
                                <th scope="col">Xóa</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="total" value="0"/>
                            <c:forEach var="item" items="${sessionScope.cart.values()}">
                                <c:set var="lineTotal" value="${item.book.price * item.quantity}"/>
                                <tr>
                                    <td>${item.book.name}</td>
                                    <td>
                                        <input type="number"
                                               name="quantity_${item.book.id}"
                                               value="${item.quantity}"
                                               min="1"
                                               max="${item.book.stock}"
                                               class="form-control" style="width: 80px;">
                                    </td>
                                    <td>${item.book.price}</td>
                                    <td>${lineTotal}</td>
                                    <td>
                                        <a href="/clients?action=removeCart&id=${item.book.id}"
                                           class="btn btn-sm btn-danger">Xóa</a>
                                    </td>
                                </tr>
                                <c:set var="total" value="${total + lineTotal}"/>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <div class="d-flex justify-content-between align-items-center mt-3">
                        <h5 class="mb-0">Tổng tiền: ${total} VND</h5>
                        <div>
                            <button type="submit" class="btn btn-warning">Cập nhật số lượng</button>
                            <a href="/clients?action=checkout" class="btn btn-primary">Thanh toán</a>
                        </div>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
