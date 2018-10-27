<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function openLogin() {
	var popupX = (window.screen.width / 2) - (1200 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height /2) - (700 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

	window.open('/Treasure/K/loginForm.do', '로그인, 회원가입',
			'status=no, height=700, width=1200, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}

function openJoin() {
	var popupX = (window.screen.width / 2) - (1200 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height /2) - (700 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

	window.open('/Treasure/K/inputForm.do', '로그인, 회원가입',
			'status=no, height=700, width=1200, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}
</script>
</head>
<body>
<c:if test="${empty sessionScope.memId}">
		
<a href="#" onclick="openLogin()">로그인</a>
<a href="#" onclick="openJoin()">회원가입</a>
		
</c:if>

<c:if test="${!empty sessionScope.memId}">


<form method="post" action="/Treasure/K/logout.do">
<input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="로그아웃"></form>
<form name="myshow" action="/Treasure/K/modify.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-lg">회원정보수정</button></form>



</c:if>


</body>
</html>