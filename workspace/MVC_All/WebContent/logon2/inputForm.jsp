<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./color.jspf"%>

<html>
<head>

<title>회원가입</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript">

function checkIt() {
	var userinput = eval("document.userinput");
	if(!userinput.id.value){
		alert("ID 입력ㄱㄱ!");
	return false;
	}
	
	if(!userinput.passwd.value){
		alert("pw 입력ㄱㄱ!");
		return false;
	}
	if(userinput.passwd.value != userinput.passwd2.value)
	{
		alert("pw 동일하게 입력ㄱㄱ");
	}
	if(!userinput.username.value){
		alert("사용자 명 입력!");
		return false;
	}
	if(!userinput.jumin1.value || !userinput.jumin2.value)
	{
		alert("주.번 입력 ");
		return false;
	}
}
//ID 중복 여부 판단
function openConfirmid(userinput){
	if(userinput.id.value == ""){
		alert("ID 입력!");
		return;
	}
	url="/MVC_All/logon/confirmId.do?id=" + userinput.id.value;
	
	open(url,"confirm","toolbar=no,location=no,status=no,menubar=np,scrollbars=no,resizable=no,width=550,height=200");
}
</script>
</head>
<bod bgcolor="${bodyback_c}">

<form method="post" action="/MVC_All/logon2/inputPro.do" name="userinput" onSubmit="return checkIt()">
<table width="600" border="1" cellspacing="0" cellpadding="3" align="center">
<tr>
<td colspan="2" height="39" align="center" bgcolor="${value_c}">
<font size="+1"><b>회원가입</b></font></td>
</tr>
<tr>
<td width="200" bgcolor="${value_c}"><b>ID 입력</b></td>
<td width="200" bgcolor="${value_c}">&nbsp;</td>
</tr>

<tr>
<td width="200">사용자 ID</td>
<td width="400">
<input type="text" name="id" size="10" maxlength="12">
<input type="button" bane="confirm_id" value="ID중복확인" Onclick="openConfirmid(this.form)">
</td>
</tr>
<tr>
<td width="200">pw</td>
<td width="400">
<input type="password" name="passwd" size="15" maxlength="12">
</td>
<tr>
<td width="200">pw 확인</td>
<td width="400">
<input type="password" name="passwd2" size="15" maxlength="12">
</td>
</tr>

<tr>
<td width="200" bgcolor="${value_c}"><b>개인정보 입력</b></td>
<td width="400" bgcolor="${value_c}">&nbsp;</td>
<tr>
<tr>
<td width="200">사용자 명</td>
<td width="400">
<input type="text" name="name" size="15" maxlength="10">
</td>
</tr>
<td width="200">E-Mail</td>
<td width="400">
<input type="text" name="email" size="40" maxlength="30">
</td>
</tr>
<tr>
<td width="200">BLOG</td>
<td width="400">
<input type="text" name="blog" size="60" maxlength="50">
</td>
</tr>
<tr>
<td colspan="2" align="center" bgcolor="${value_c}">
<input type="submit" name="confirm" value="등 록">
<input type="reset" name="reset" value="재 입력">
<input type="button" value="가입 x" onclick="document.location.href='/MVC_All/logon/main.do'"> 
</td>
</tr>
</table>
</form>
</body>
</html>