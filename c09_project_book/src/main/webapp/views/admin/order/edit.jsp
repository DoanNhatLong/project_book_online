<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/14/2026
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit</title>
  <c:import url="../library-css.jsp"/>
  <c:import url="../admin-css.jsp"/>
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

<div class="container">
  <form action="/admin/order?action=edit" method="post">
    <input type="number" class="form-control" name="id_customer" placeholder="Nhập id_customer" required/>
    <input type="number" class="form-control" name="total" placeholder="Nhập tông " required/>
    <input type="text" class="form-control" name="status" placeholder="Nhập status"/>
    <input hidden="hidden" class="form-control" name="idEdit"  value=${idEdit} />
    <input type="date" class="form-control" name="time" placeholder="Nhập ngày mua " required/>

    <button type="submit"> Xác nhận sửa</button>
  </form>
</div>


</body>
</html>
