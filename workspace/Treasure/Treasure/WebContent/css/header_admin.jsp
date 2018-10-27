<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Treasure/css/head.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

<title>Treasure</title>
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
<div class = "header2">
	<div class="header"><a href="/Treasure/J/main.do">Admin</a></div>
	<button class="tablink" onclick="location.href='/Treasure/P/creativeMain.do'">Creative Arts</button>
	<button class="tablink" onclick="location.href='/Treasure/P/retroMain.do'">Retro Collections</button>
	<button class="tablink" onclick="location.href='/Treasure/P/auctionMain.do'">Auction</button>
	<button class="tablink" onclick="location.href='/Treasure/J/aboutus.do'">Community</button>

<c:if test="${empty sessionScope.memId }">
	<div class="right">
		<a onclick="openLogin()">Log in</a>| &nbsp;<a onclick="openJoin()">Join us</a>
	</div>
</c:if>
<c:if test="${!empty sessionScope.memId}">
	<div class="right">
		<a href="/Treasure/K/logout.do">Log out</a>| &nbsp;<a href="/Treasure/S/adminUserList.do">Admin page</a>
	</div>
</c:if>
</div>
</body>
</html>