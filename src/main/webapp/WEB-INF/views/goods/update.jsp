<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head> <!--부트스트랩 스크립트와 CSS, JQuery를 연동-->
    <title>인싸 쇼핑몰</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<!--메뉴 구성-->
<!--같은 위치에 있으면 파일명만, 다른 곳에 있으면 경로/파일명-->
<!--..(현재폴더를 벗어나서)/파일명, ../head/파일명 (현재폴더에서 벗어나서 head폴더로 들어가서)-->
<jsp:include page="../menu.jsp"/>

<!--본문 내용-->
</body>
<div class="row"><!--1행에는 12칸으로-->
    <div class="col-sm-3"></div><!--여백-->
    <div class="col-sm-6">
        <form action="/goods-update" method="post">
            <div class="mb-3 mt-3"><!--데이터베이스의 필드명을 이용해서-->
                <label for="gno" class="form-label">상품번호:</label>  <!--Controller mav.addObject("list"과 name="gno" 결합-->
                <input type="text" class="form-control" id="gno" name="gno" value="${list.gno}" readonly>
            </div>
            <div class="mb-3"><!--데이터베이스의 필드명을 이용해서-->
                <label for="ggoods" class="form-label">상품명:</label>
                <input type="text" class="form-control" id="ggoods" name="ggoods" value="${list.ggoods}">
            </div>
            <div class="mb-3">
                <label for="gcontent" class="form-label">상품설명:</label>
                <textarea class="form-control" id="gcontent" name="gcontent" rows="5">${list.gcontent}</textarea>
            </div>
            <div class="mb-3">
                <label for="gprice" class="form-label">상품가격:</label>
                <input type="number" class="form-control" id="gprice" name="gprice" value="${list.gprice}">
            </div>
            <div class="mb-3">
                <label for="gquan" class="form-label">재고수량:</label>
                <input type="number" class="form-control" id="gquan" name="gquan" value="${list.gquan}">
            </div>
            <div class="mb-3"><!--파일업로드-->
                <label for="gimgfile" class="form-label">상품이미지:</label>
                <input type="text" class="form-control" id="gimgfile" name="gimgfile" value="${list.gimgfile}" readonly>
            </div>
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">상품수정</button>
                <button type="button" class="btn btn-warning" onclick="location.href='/goods-delete?gno=${list.gno}'">삭제</button>
                <button type="button" class="btn btn-secondary" onclick="location.href='/goods-list2'">목록</button>
            </div>
        </form>
    </div><!--입력폼-->
    <div class="col-sm-3"></div><!--여백-->
</div>


</html>