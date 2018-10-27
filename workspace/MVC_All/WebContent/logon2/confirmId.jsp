<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./color.jspf" %>

<html>
<head>
<title>ID 중복확인</title>
<link href="stule.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="${bodyback_c}">
<c:if test="${check == 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
<tr bgcolor="${title_c}>
<td height="39">${id} 이미 사용중인 ID !</td>
</tr>
</table>
<form name="checkForm" method="post" action="/MVC_All/logon2/confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
<tr>
<td bgcolor="${value_c}" align="center">
다른 ID 선택하셈<p>
<input type="text" size="10" maxlength="12" name="id">
<input type="submit" value="ID중복확인">
</td>
</tr>
</table>
</form>
</c:if>

<c:if test="${check == -1}">
<table width="270 border="0" cellspacing="0" cellpadding="5">
<tr bgcolor="${title_c}">
<td align="center">
<p> 입력한 ${id}(은)는  사용가능한 ID!</p>
<input type="button" value="닫기" onclick="setid()">
</td>
</tr>
</table>
</c:if>
</body>
</html>

<script language='javascript'>
<!--
function setid()
{
	opener.document.userinput.id.value="${id}";
	selt.clost();
}
-->
</script>