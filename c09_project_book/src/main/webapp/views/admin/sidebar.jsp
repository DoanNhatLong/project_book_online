<%@ page contentType="text/html;charset=UTF-8" %>

<div class="sidebar p-3">
    <h4 class="text-center mb-4">📚 ADMIN PANEL</h4>

    <a href="${pageContext.request.contextPath}/admin/book" class="active">
        <i class="bi bi-book"></i> Quản lý sách
    </a>

    <a href="${pageContext.request.contextPath}/admin/account">
        <i class="bi bi-people"></i> Quản lý user
    </a>

    <a href="${pageContext.request.contextPath}/admin/order">
        <i class="bi bi-cart-check"></i> Quản lý đơn hàng
    </a>
</div>
