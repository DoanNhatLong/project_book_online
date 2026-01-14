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


</style>