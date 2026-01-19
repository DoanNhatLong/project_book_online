<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>

    <c:import url="../library-css.jsp"/>
    <c:import url="../admin-css.jsp"/>

    <style>
        body {
            overflow: auto;
        }

        .container-fluid {
            padding: 1rem !important;
        }

        .card {
            margin-bottom: 1rem;
        }

        .table {
            font-size: 0.85rem;
        }

        .table th,
        .table td {
            padding: 0.35rem 0.5rem;
            vertical-align: middle;
        }

        .btn-sm {
            padding: 0.15rem 0.4rem;
            font-size: 0.75rem;
        }
    </style>
</head>

<body>

<c:if test="${sessionScope.message != null}">
    <div class="toast-container position-fixed top-0 end-0 p-3">
        <div class="toast show">
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

<div class="d-flex">

    <c:import url="../sidebar.jsp"/>

    <div class="flex-grow-1 d-flex flex-column">

        <c:import url="../header.jsp"/>

        <div class="container-fluid">

            <c:import url="../statistic.jsp"/>

            <div class="card shadow-sm mt-3">
                <div class="card-body p-2">
                    <div class="d-flex justify-content-between align-items-center mb-2">
                        <h6 class="mb-0">Quản lý đơn hàng</h6>
                        <a href="/admin/order?action=add" class="btn btn-sm btn-success">Thêm</a>
                    </div>

                    <table class="table table-hover table-sm align-middle mb-0">
                        <thead class="table-dark small">
                        <tr>
                            <th>#</th>
                            <th>ID khách hàng</th>
                            <th>Tổng giá</th>
                            <th>Ngày mua</th>
                            <th>Hành động</th>
                        </tr>
                        </thead>
                        <tbody class="small">
                        <c:forEach items="${orderList}" var="order" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${order.id_customer}</td>
                                <td>${order.total}</td>
                                <td>${order.time}</td>
                                <td>
                                    <a href="/admin/order?action=edit&id=${order.id}"
                                       class="btn btn-sm btn-primary">Sửa</a>
                                    <a href="/admin/order?action=approve&idOrder=${order.id}"
                                       class="btn btn-sm btn-success"
                                    >Duyệt đơn</a>
                                    <button type="button"
                                            class="btn btn-sm btn-danger"
                                            data-bs-toggle="modal"
                                            data-bs-target="#deleteOrderModal"
                                            data-id="${order.id}">
                                        Xóa
                                    </button>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>

        </div>
    </div>

</div>

<c:import url="../library-js.jsp"/>

<div class="modal fade" id="deleteOrderModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form method="get" action="/admin/order">
                <div class="modal-header">
                    <h5 class="modal-title">Xác nhận xóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="deleteId">
                    <p>Bạn có chắc chắn muốn xóa đơn hàng này không?</p>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                        Hủy
                    </button>
                    <button type="submit" class="btn btn-danger">
                        Xóa
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    const deleteModal = document.getElementById('deleteOrderModal');
    deleteModal.addEventListener('show.bs.modal', function (event) {
        const button = event.relatedTarget;
        document.getElementById('deleteId').value = button.getAttribute('data-id');
    });
</script>
</body>
</html>
