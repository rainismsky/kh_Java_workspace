<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<link href="/Treasure/css/menu.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

</head>
<body>
	<nav class="row"> <nav class="left">
	<h2>Admin</h2>
	<h4>관리자 페이지 입니다.</h4>
	<hr width="100%" margin-left="10px">
	<ul id="myMenu">
		<li><a href="/Treasure/S/adminUserList.do">회원리스트</a></li>
		<li><a href="/Treasure/S/adminLeaveList.do">탈퇴리스트</a></li>
		<li><a href="/Treasure/S/adminBlackList.do">블랙리스트</a></li>
		<li><a href="/Treasure/S/adminLike.do">좋아요순위</a></li>
		<li><a href="/Treasure/S/adminReportList.do">작품신고내역</a></li>
		<li><a href="/Treasure/S/myRecieveMsgList.do">쪽지함</a></li>
	</ul>
	<input type="text" id="mySearch" style="visibility:hidden">
	</nav> </nav>
</body>
</html>