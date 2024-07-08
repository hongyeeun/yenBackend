<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
	<!-- 기존주소는 member폴더 안 register.jsp 이므로 http://127.0.0.1:8888/member/register.jsp 로 접속-->
	<!-- 보안상의 이유로 주소를 변경해준다. -> 서블릿 URL로 변경-->	
	<!--  URL 변경하려면 WEB-INF의 views 파일에서 폴더 만들어서 jsp 파일 넣어야한다.
		  그 전의 실습은  webapp 파일에 폴더 생성하여 jsp 파일 만들었음 -->
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요</h3>
		<form action="/member/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
			아이디 : <input type="text" name="member-id"> <br>
			비밀번호 : <input type = "password" name="member-pw"> <br> 
			이름 : <input type = "text" name="member-name"> <br>
			성별 : 
				남 <input type="radio" name="gender" value="M">
				여 <input type="radio" name="gender" value="F"> <br>
			나이 : <input type="number" name="age"> <br>
			이메일 : <input type="text" name="email"> <br>
			전화번호 : <input type="text" name="phone"> <br>
			주소 : <input type="text" name="address"> <br>
			취미 : <input type="text" name="hobby"> <br>
			<input type="submit" value="회원가입"> 
			<input type="reset" value="취소">
		</fieldset>
		</form>
	</body>
</html>