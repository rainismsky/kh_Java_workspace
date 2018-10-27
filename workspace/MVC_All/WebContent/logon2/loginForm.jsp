<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./color.jspf" %>

<html>
<head>

<title>LOGIN</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script language="javascript">

function begin() {
	document.myform.id.focus();
}
function checkIt(){
	if(!document.myform.id.value){
		alert{"니 이름 입력 안했음 똑바로 안함?"};
	document.myform.id.focus();
		return false;
	}
	if(!document.myform.passwd.value){
		alert("비번 입력  안함");
		document.myform.passwd.focus();
		return false;
	}
}

</script>
</head>
<body onload="begin()" bgcolor="${bodyback_c}">
<form name="myform" action="/MVC_All/logon2/loginPro.do" method="post" onSubmit="return checkIt()">
<table cellSpacing=1 cellPadding=1 width="260" border=1 align="center">

<tr height="30">
<td colspan="2" align="middle" bgcolor="${title_c}"><strong>회원 로그인</strong></td></tr>

<tr height="30">
<td width="110" bgcolor="${title_c}" align=center>ID</td>
<td width="150" bgcolor="${value_c}" align=center>
<input type="text" name="id" size="15" maxlength="12"></td></tr>
<tr height="30">
<td width="110" bgcolor="${title_c}" align=center>p.w</td>
<td width="150" bgcolor="${value_c}" align=center>
<input type=password name="passwd" size="15" maxlength="12"></td></tr>
<tr height="30">
<td colspan="2" align="middle" bgcolor="${title_c}">
<input type=submit value="로그인">
<input type=reset value="다시 입력">
<input type="button" value="회원가입" 
onclick="document.lodation.href="/MVC_All/logon2/inputForm.do"></td></tr>
</table>
</form>

</body>
</html>