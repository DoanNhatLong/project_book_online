<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <c:import url="../library-css.jsp"/>
    <c:import url="../admin-css.jsp"/>
</head>
<body>

<div class="d-flex">

    <!-- Sidebar -->
    <c:import url="../sidebar.jsp"/>

    <!-- Main content -->
    <div class="flex-grow-1">

        <!-- Header -->
        <c:import url="../header.jsp"/>

        <!-- Content -->
        <div class="container-fluid p-4">

            <!-- Statistic -->
            <c:import url="../statistic.jsp"/>

            <!-- Table -->
            <div class="card shadow-sm mt-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <h5 class="mb-4">➕ Thêm sách mới</h5>
                        <c:if test="${param.mess == 'true'}">
                            <div class="alert alert-success text-danger py-0">Cập nhật trạng thái thành công</div>
                        </c:if>
                        <c:if test="${param.mess == 'false'}">
                            <div class="alert alert-danger text-danger py-0">Cập nhật thất bại</div>
                        </c:if>
                    </div>
                    <form action="/admin/book?action=add"
                          method="post"
                          enctype="multipart/form-data"
                          class="card shadow-sm p-3">
                        <!-- Row 1 -->
                        <div class="row g-2">
                            <div class="col-md-4">
                                <label class="form-label small">Tên sách</label>
                                <input type="text" name="name" class="form-control form-control-sm" required>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label small">Tác giả</label>
                                <input type="text" name="author" class="form-control form-control-sm">
                            </div>
                            <div class="col-md-4">
                                <label class="form-label small">Thể loại</label>
                                <select name="category-id" class="form-select form-select-sm" required>
                                    <option value="">--- Chọn ---</option>
                                    <c:forEach items="${categoryList}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <!-- Row 2 -->
                        <div class="row g-2 mt-2">
                            <div class="col-md-4">
                                <label class="form-label small">Giá</label>
                                <input type="text" name="price" class="form-control form-control-sm" required>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label small">Số lượng</label>
                                <input type="number" name="stock" class="form-control form-control-sm" value="1" min="1" required>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label small">Ảnh bìa</label>
                                <input type="file" name="image-url" class="form-control form-control-sm" accept="image/*" required>
                            </div>
                        </div>

                        <!-- Description -->
                        <div class="mt-2">
                            <label class="form-label small">Mô tả</label>
                            <textarea name="desc"
                                      class="form-control form-control-sm"
                                      rows="2"
                                      required></textarea>
                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-end gap-2 mt-3">
                            <a href="/admin/book" class="btn btn-secondary btn-sm">Huỷ</a>
                            <button type="submit" class="btn btn-primary btn-sm">Lưu</button>
                        </div>

                    </form>


                </div>
            </div>

        </div>
    </div>

</div>
<c:import url="../library-js.jsp"/>
</body>
</html>
