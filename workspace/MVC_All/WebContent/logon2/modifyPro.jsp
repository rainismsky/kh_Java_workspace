<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./color.jspf" %>

<html>
<head>

<title>회원 정보 수정</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
<tr bgcolor="${title_c}">
<td height="39" align="center">
<font size="+1"><b>회원 정보가 수정됬다.</b></font></td>
</tr>
<tr>
<td bgcolor="${value_c}" align="center">
<p>입력한 내용대로 수정 완료!</p>
</td>
</tr>
<tr>
<td bgcolor="${valud_c}" align="center">
<form>
<input type="button" value="메인으로 ㄱㄱ" onclick="document.location.href='/study/appendix/logon/main.do">
</form>
5초후 메인으로 이동함!.<meta http-equiv-"Refresh" content="5;url=/MVC_All/logon2/main.do">
</td>
</tr>
</table>
</body>
</html>