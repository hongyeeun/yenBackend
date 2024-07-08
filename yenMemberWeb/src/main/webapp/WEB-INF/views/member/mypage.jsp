<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<h1>마이페이지</h1>
		<!-- span처럼 양쪽으로 태그가 되어있으면 가운데에 써주고, 
			input처럼 하나만 있으면 value값으로 넣어줌 -->
		<!-- member를 서블릿에서 받았고, 이 member의 필드값을 키값으로 쓸 수 있다. 
			getter메소드 안써도 member.필드 이렇게 적으면 된당-->
		<form action="/member/update.do" method="post">
			<input type="hidden" name="memberId" value="${member.memberId }"> 
			<!-- 숨김할 땐 hidden 태그 사용한다. -->
			아이디 : 	<span>${member.memberId }</span> <br>
	<!-- 		비밀번호 : <input type = "password" value=""> -->
			이름 : 		<span>${member.memberName }</span> <br>
			성별 : 		<span>${member.gender }</span> <br>
			나이 : 		<span>${member.age }</span> <br>
			이메일 : 	<input type="text" 	name="email" 	value='${member.email }'> <br>
			전화번호 : 	<input type="text" 	name="phone" 	value='${member.phone }'> <br>
			주소 : 		<input type="text" 	name="address" 	value='${member.address }'> <br>
			취미 : 		<input type="text"	name="hobby"	value="${member.hobby }"> <br>
			가입일자 : 	<span>${member.regDate }</span>  <br>
			<input type="submit" value="수정하기">
		</form>
	</body>
</html>