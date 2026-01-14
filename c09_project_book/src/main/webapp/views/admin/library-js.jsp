<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/14/2026
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
        integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- DataTables core -->
<script src="https://cdn.datatables.net/1.13.8/js/jquery.dataTables.min.js"></script>

<!-- DataTables Bootstrap 5 -->
<script src="https://cdn.datatables.net/1.13.8/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('.table').DataTable({
            pageLength: 10,
            lengthChange: false,
            language: {
                search: "Tìm kiếm:",
                paginate: {
                    next: "Sau",
                    previous: "Trước"
                },
                zeroRecords: "Không có dữ liệu"
            },
            ordering: false,
            info: false
        });
    });
</script>
