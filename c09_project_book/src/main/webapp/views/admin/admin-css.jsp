<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
body {
    background-color: #f4f6f9;
}

.sidebar {
    width: 260px;
    min-height: 100vh;
    background: linear-gradient(180deg, #0f2027, #203a43, #2c5364);
}

.sidebar h4 {
    color: #7CFF6B;
}

.sidebar a {
    color: #e0e0e0;
    text-decoration: none;
    padding: 8px 16px;
    border-radius: 8px;
    margin: 6px 0;
    line-height: 1.2;
    font-size: 15px;
    display: flex;
    align-items: center;
    gap: 10px;
}

.sidebar a:hover,
.sidebar a.active {
    background-color: #198754;
    color: #fff;
}

.admin-header {
    background: #000;
    color: #7CFF6B;
    padding: 15px 20px;
    font-size: 18px;
    font-weight: bold;
}

.card {
    border-radius: 12px;
}

/*định dang cho nút phân trang*/

     /* Nút phân trang */
 .dataTables_wrapper .pagination .page-link {
     color: #198754;              /* xanh Bootstrap */
 }

/* Trang đang active */
.dataTables_wrapper .pagination .page-item.active .page-link {
    background-color: #198754;
    border-color: #198754;
    color: #fff;
}

/* Hover */
.dataTables_wrapper .pagination .page-link:hover {
    background-color: #d1e7dd;
    color: #198754;
}

/* Disabled (Trước / Sau khi không bấm được) */
.dataTables_wrapper .pagination .page-item.disabled .page-link {
    color: #6c757d;
    background-color: #f8f9fa;
}

.table {
    font-size: 0.8rem;
}

.table th,
.table td {
    padding: 0.45rem 0.5rem;
}
/* Thu nhỏ pagination */
.dataTables_wrapper .pagination .page-link {
    font-size: 0.8rem;      /* nhỏ chữ */
    padding: 0.25rem 0.5rem; /* thu chiều cao & ngang */
}

/* Active page */
.dataTables_wrapper .pagination .page-item.active .page-link {
    font-size: 0.8rem;
}

/* Trước / Sau */
.dataTables_wrapper .pagination .page-link {
    min-width: auto;
}
/* KHÓA SCROLL TOÀN TRANG */
html, body {
    height: 100%;
    overflow: hidden;
}

/* Main content full height */
.main-content {
    height: 100vh;
}

/* Content (dưới header) */
.admin-content {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    overflow: hidden;
}

/* Card table chiếm phần còn lại */
.admin-table-card {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    overflow: hidden;
}

/* Scroll chỉ trong table */
.table-scroll {
    flex-grow: 1;
    overflow-y: auto;
}

/* Sticky header table */
.table-scroll thead th {
    position: sticky;
    top: 0;
    z-index: 10;
    background: #212529;
}

/* Scrollbar đẹp */
.table-scroll::-webkit-scrollbar {
    width: 6px;
}
.table-scroll::-webkit-scrollbar-thumb {
    background: #bbb;
    border-radius: 4px;
}
/* Khung ngoài – chiếm gần full chiều cao màn hình */
.table-wrapper {
    background: #fff;
    border-radius: 10px;
    padding: 12px;
    height: calc(100vh - 220px); /* chỉnh số này nếu muốn sát hơn nữa */
    display: flex;
    flex-direction: column;
}

/* Khung cuộn dọc */
.table-container {
    flex: 1;
    overflow-y: auto;
    overflow-x: hidden; /* ❌ BỎ SCROLL NGANG */
}

/* Table chuẩn */
.admin-table {
    width: 100%;
    border-collapse: collapse;
    table-layout: fixed; /* QUAN TRỌNG để không tràn ngang */
}

/* Header */
.admin-table thead th {
    background: #1f262b;
    color: #fff;
    padding: 10px;
    font-size: 14px;
    text-align: center;
    white-space: nowrap;
}

/* Body */
.admin-table tbody td {
    padding: 10px;
    font-size: 14px;
    text-align: center;
    border-bottom: 1px solid #e5e5e5;

    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis; /* text dài tự ... */
}

/* Ảnh */
.admin-table img {
    width: 40px;
    height: auto;
    object-fit: cover;
}

/* Cột tên sách rộng hơn */
.admin-table th:nth-child(3),
.admin-table td:nth-child(3) {
    width: 220px;
}

/* Cột hành động */
.admin-table th:last-child,
.admin-table td:last-child {
    width: 130px;
}


</style>