<%@ page contentType="text/html;charset=UTF-8" %>
<style>
    .stat-card {
        min-height: 50px;
        padding-bottom: 5px/* ~70% so với card mặc định */
    }

    .stat-card .card-body {
        padding: 10px 5px; /* giảm padding */
        font-size: 60%; /* 🔥 giảm toàn bộ font trong card */
    }
</style>
<div class="row g-4">

    <div class="col-md-4">
        <div class="card shadow-sm stat-card">
            <div class="card-body d-flex justify-content-between">
                <h5 class="card-title text-success">📘 Tổng sách</h5>
                <p class="fs-3 fw-bold mb-0 mx-2">1000</p>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card shadow-sm stat-card">
            <div class="card-body d-flex justify-content-between">
                <h5 class="card-title text-success">👤 Người dùng</h5>
                <p class="fs-3 fw-bold mb-0 mx-2">1000</p>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="card shadow-sm stat-card">
            <div class="card-body d-flex justify-content-between">
                <h5 class="card-title text-success">🛒 Đơn hàng</h5>
                <p class="fs-3 fw-bold mb-0 mx-2 ">1000</p>
            </div>
        </div>
    </div>

</div>
