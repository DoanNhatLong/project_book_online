<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đọc sách</title>

    <!-- PDF.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdf.js/3.11.174/pdf.min.js"></script>

    <style>
        #pdf-canvas {
            border: 1px solid #ccc;
            width: 100%;
        }
        .controls {
            margin: 10px 0;
        }
    </style>
</head>
<body>
Hello
<h2>${book.name}</h2>

<div class="controls">
    <button onclick="prevPage()">⬅ Trang trước</button>
    <span>Trang <span id="page-num"></span> / <span id="page-count"></span></span>
    <button onclick="nextPage()">Trang sau ➡</button>
</div>

<canvas id="pdf-canvas"></canvas>

<script>
    const url = "${pdfUrl}";
    console.log(url)

    let pdfDoc = null;
    let pageNum = 1;
    let pageRendering = false;
    let canvas = document.getElementById('pdf-canvas');
    let ctx = canvas.getContext('2d');

    pdfjsLib.getDocument(url).promise.then(pdf => {
        pdfDoc = pdf;
        document.getElementById('page-count').textContent = pdf.numPages;
        renderPage(pageNum);
    });

    function renderPage(num) {
        pageRendering = true;

        pdfDoc.getPage(num).then(page => {
            const viewport = page.getViewport({ scale: 1.5 });
            canvas.height = viewport.height;
            canvas.width = viewport.width;

            const renderContext = {
                canvasContext: ctx,
                viewport: viewport
            };

            page.render(renderContext).promise.then(() => {
                pageRendering = false;
                document.getElementById('page-num').textContent = num;
            });
        });
    }

    function nextPage() {
        if (pageNum >= pdfDoc.numPages) return;
        pageNum++;
        renderPage(pageNum);
    }

    function prevPage() {
        if (pageNum <= 1) return;
        pageNum--;
        renderPage(pageNum);
    }
</script>

</body>
</html>
