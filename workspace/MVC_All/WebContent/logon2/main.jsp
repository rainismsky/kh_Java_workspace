<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./color.jspf" %>

<html>
<head>
<title>☆★☆★MAIN_HOMEPAGE★☆★☆</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="${bodyback_c}">

<c:if test="${empty sessionScope.memId}">

<table width=500 cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
<td width="300" bgcolor="${bodyback_c}" height="20">
&nbsp;
</td>

<form name="inform" method="post" action="/Education/logon/loginPro.do">

<td bgcolor="${title_c}" width="500" align="right">ID</td>
<td width="100" bgcolor="${value_c}">
<input type="text" name="id" size="15" maxlength="10"></td>
</tr>
<tr>
<td rowspan="2" bgcolor="${bodyback_c}" width="300">★☆★☆  MAIN ☆★☆★</td>
<td bgcolor="${title_c}" width="100" align="right">PW</td>
<td width="100" bgcolor="${value_c}">
<input type="password" name="passwd" size="15" maxlength="10"></td>
</tr>
<tr>
<td colsapn="3" bgcolor="${title_c}" align="center">
<input type="submit" name="Submit" value="로그인">
<input type="button" value="회원가입 " onclick="document.location.href='/Education/logon/inputForm.do'">
</td></tr></form></table>

</c:if>

<c:if test="${!empty sessionScope.memId}">
<table width=500 cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
<td width="300" bgcolor="${boduyback_c}"height="20">ㅋㅋㅋㅋ</td>

<td rowspan="3" bgcolor="${value_c}" align="center">
${sessiongScope.memId}가 <br>방문함!
<form method="post" action="/Education/logon/logout.do">
<input type="submit" value="로그아웃">
<input type="button" value="회원 정보 변경" onclick="document.location.href='/Education/logon/modify.do'">
</form>
</td>
</tr>
<tr>
<td rowspan="2" bgcolor="${bodyback_c}" width="300" >메인이다</td>
</tr>
</table>
<br>
</c:if>
</body>
</html>