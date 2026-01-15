<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Approve Order</title>
  <c:import url="../library-css.jsp"/>
  <c:import url="../admin-css.jsp"/>
</head>

<body class="bg-light">

<div class="container mt-5" style="max-width: 900px">

  <c:if test="${not empty sessionScope.billDto}">
    <form method="post" action="/admin/order?action=confirmApprove">

      <div class="card shadow">

        <div class="card-header bg-dark text-white">
          <h5 class="mb-0">Thông tin đơn hàng</h5>
        </div>

        <div class="card-body">

          <c:set var="info" value="${sessionScope.billDto[0]}"/>

          <div class="row mb-3">
            <div class="col-md-6">
              <strong>Mã đơn:</strong> ${info.id}
            </div>
            <div class="col-md-6">
              <strong>Tên khách hàng:</strong> ${info.name}
            </div>
          </div>

          <div class="row mb-4">
            <div class="col-md-6">
              <strong>Số điện thoại:</strong> ${info.phone}
            </div>
            <div class="col-md-6">
              <strong>Địa chỉ:</strong> ${info.address}
            </div>
          </div>

          <hr>

          <h6 class="mb-3">Danh sách sách</h6>

          <c:forEach var="item" items="${sessionScope.billDto}">
            <div class="border rounded p-3 mb-3">

              <div class="row">
                <div class="col-md-3">
                  <strong>ID Book:</strong> ${item.idBook}
                </div>

                <div class="col-md-6">
                  <strong>Tên sách:</strong> ${item.bookName}
                </div>

                <div class="col-md-3">
                  <strong>Số lượng:</strong> ${item.quantity}
                </div>
              </div>

            </div>
          </c:forEach>

        </div>

        <div class="card-footer text-end">
          <input type="hidden" name="idOrder" value="${sessionScope.idOrder}">
          <input type="hidden" name="idCustomer" value="${info.id}">
          <button type="submit" class="btn btn-success">
            Xác nhận đơn hàng
          </button>
        </div>

      </div>
    </form>
  </c:if>

</div>

</body>
</html>
