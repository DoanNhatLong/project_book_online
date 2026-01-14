<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thanh toán</title>
    <c:import url="/views/library.jsp"/>
</head>

<body class="bg-light">
<div class="container mt-5" style="max-width: 600px">
    <div class="card shadow-sm">
        <div class="card-body">

            <h4 class="text-center mb-4">Thanh toán</h4>

            <c:set var="total" value="0"/>
            <c:forEach items="${sessionScope.checkoutItems}" var="item">
                <c:set var="total" value="${total + (item.quantity * item.price)}"/>
            </c:forEach>

            <div class="d-flex justify-content-between mb-3">
                <span>Tổng tiền gốc</span>
                <strong><span id="baseTotal">${total}</span> đ</strong>
            </div>

            <hr>

            <h6 class="mb-3">Phương thức thanh toán</h6>

            <c:forEach items="${paymentTypes}" var="p">
                <div class="form-check mb-2">
                    <input class="form-check-input" type="radio" name="payment" id="pay${p.id}" onclick="applyRate(${p.rate})">
                    <label class="form-check-label" for="pay${p.id}">
                            ${p.name} (Giảm ${p.rate}%)
                    </label>
                </div>
            </c:forEach>

            <hr>

            <div class="d-flex justify-content-between mb-4">
                <span>Tổng tiền phải thanh toán</span>
                <strong class="text-danger">
                    <span id="finalTotal">${total}</span> đ
                </strong>
            </div>

            <div class="d-grid">
                <button class="btn btn-primary" type="button"
                        onclick="
                            const selected = document.querySelector('input[name=payment]:checked');
                            if(!selected){
                                alert('Vui lòng chọn phương thức thanh toán');
                                return;
                            }
                            new bootstrap.Modal(document.getElementById('confirmModal')).show();
                        ">
                    Xác nhận thanh toán
                </button>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/clients?action=processCheckout">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Xác nhận thanh toán</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-2">
                        Tổng tiền gốc: <strong id="modalBaseTotal">${total}</strong> đ
                    </div>
                    <div class="mb-2">
                        Giảm giá: <strong id="modalDiscount">0</strong> đ
                    </div>
                    <div class="mb-2">
                        Tổng thanh toán: <strong id="modalFinal">${total}</strong> đ
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số tài khoản</label>
                        <input type="text"
                               name="accountNumber"
                               class="form-control"
                               placeholder="Nhập số tài khoản "
                               required>
                    </div>
                    <input type="hidden" name="total" id="modalTotalInput" value="${total}">
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Xác nhận</button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    const accountInput = document.querySelector('input[name="accountNumber"]');

    document.querySelectorAll('input[name="payment"]').forEach(radio => {
        radio.addEventListener('change', function () {
            const paymentId = this.id.replace("pay", "");

            if (paymentId === "1") {
                accountInput.required = false;
                accountInput.value = "";
            } else {
                accountInput.required = true;
            }
        });
    });
</script>

<script>
    const baseTotal = Number(document.getElementById("baseTotal").innerText);

    function applyRate(ratePercent) {
        const discount = Math.round(baseTotal * ratePercent / 100);
        const finalTotal = baseTotal - discount;

        document.getElementById("finalTotal").innerText = finalTotal;
        document.getElementById("modalDiscount").innerText = discount;
        document.getElementById("modalFinal").innerText = finalTotal;
        document.getElementById("modalTotalInput").value = baseTotal;
    }
</script>

</body>
</html>
