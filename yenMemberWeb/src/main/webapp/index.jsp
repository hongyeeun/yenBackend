<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>MemberWeb Home</title>
	</head>
	<body>	
	<!-- 127.0.0.1:8888/ (기본값) 이렇게 할 경우 
	무조건 index.jsp 가 나오고 index.jsp가 없으면 오류가 뜬다.  -->
		<h1>환영합니다 MemberWeb Home입니다~</h1>
		<!-- if문을 이렇게 쓴다 -> JSTL문 
			memberId값이 null이 아닌 경우 -> ne -->
		<c:if test="${sessionScope.memberId ne null }">
		<!--  request와 sessionScope 에 memberId가 중복이 될 까봐
		sessionScope.memberId로 적어준 것이고 session에만 있으면 생략 가능함-->
		<a href ="/member/mypage.do?memberId=${memberId }"> 마이페이지</a>
		<!-- 밑의 것은 아이디가 해당 아이디일때를 나타내는 것이다. -> 스트링쿼리?라고 한다.  -->
		<a href ="/member/remove.do?memberId=${memberId }"> 회원탈퇴</a> <br>
<%-- 		<form action="/member/remove.do" method="get">
			<input type="hidden" name="memberId" value="${memberId }"> 
			<input type="submit" value="회원탈퇴">
		</form> 		같은 기능을 한다. --%>	
		<a href="/member/logout.do">로그아웃</a>
		</c:if>
		<!--  memberId값이 null인 경우 -> eq -->
		<c:if test="${sessionScope.memberId eq null }">
		<form action="/member/login.do"	method="post">
		<fieldset>
			<legend>로그인</legend>
			ID : <input type="text"	name="memberId"> <br>
			PW : <input type="password" name="memberPw"> <br> 
			<input type="submit" value="로그인">	
		</fieldset>
		</form>
		</c:if>
	</body>
</html>