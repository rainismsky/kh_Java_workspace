<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./color.jspf" %>

<html>
<head>

<title>회원 정보 수정</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
<table width=500 cellpadding="0" cellspacing="0" align="center">
<tr>
<td>
<form name=-"myform" action="/MVC_All/logon2/modifyForm.do" method="post">
<INPUT type="hidden" name="id" value="${sessionScope.memId}">
<INPUT type="sybmit" value="회원 정보 수정">

</form>
</td>
<td>
<form name="myform" action="/MVC_All/logon2/deleteForm.do" method="post">
<INPUT type="hidden" name="id" value="${sessionScope.memId}">
<INPUT type="submit" value="회원 탈퇴">
</form>
</td>
<td>
<form name="myform" action="/MVC_All/logon2/main.do" method="post">
<INPUT type="submit" value="메인ㄱㄱ">
</form>
</td>
</tr>
</table>
</body>
</html>