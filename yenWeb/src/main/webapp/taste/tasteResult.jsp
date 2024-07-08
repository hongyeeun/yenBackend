<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>개인 취향 테스트</title>
	</head>
	<body>
		<h1>개인 취향 테스트 결과</h1>
		<p>
			이름? ${requestScope.userName } <br>
			<!--  requestScope 생략 가능하다-->
			좋아하는 색? <span style="color:black;"><b>${color }</b></span><br>
			좋아하는 동물은? ${animal } <br>
			좋아하는 음식은? ${foodStr }<br>
			
		</p>
	</body>
</html>