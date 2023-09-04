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
<div class="row">
    <div class="col-sm-2"></div><!--여백-->
    <div class="col-sm-8">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>상품가격</th>
                <th>재고수량</th>
                <th>이미지</th>
                <th>작업</th>
            </tr>
            </thead>
            <tbody>
            <!--반복문으로 처리-->
            <!--Controller에서 list부분에 있는 mav.addObject("lists"으로 반복문 items var(작성자마음대로)-->
            <!--변수는 var에서 선언된 이름과 VO에 이름을 결합해서 사용-->
            <c:forEach var="list" items="${lists}">
                <tr>
                    <td>${list.gno}</td>
                    <td>${list.ggoods}</td>
                    <td>${list.gprice}</td>
                    <td>${list.gquan}</td>
                    <td>${list.gimgfile}</td>
                    <td><button type="button" class="btn btn-primary"
                                onclick="location.href='/goods-update?gno=${list.gno}'">수정/삭제</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-2"></div><!--여백-->
</div>
</body>
</html>