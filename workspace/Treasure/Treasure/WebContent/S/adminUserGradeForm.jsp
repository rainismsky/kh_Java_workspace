<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script>
function check() {
    document.getElementById("${udb.user_grade}").checked = true;
}
function cancel() {
	self.close();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<div style = "width : 170px; margin : 0 auto;"><h3>회원 등급 관리</h3>
</div>
<table style = "width : 400px; height :250px; margin : 0 auto; border : 3px solid  #e8e8e8;">
<tr>
<td rowspan = "3" style = "width : 120px;"><img width="150px;" src="${pageContext.request.contextPath}${udb.user_photo}"/>
</td>
<td>${udb.user_name} (${udb.user_name}) <a href="/Treasure/S/adminUserDetail.do?user_id=${udb.user_id}"><button style = "background-color: white; width : 80px;">회원정보</button></a>
</td>
</tr>
<tr>
<td>현재등급 : ${udb.user_grade}
</td>
</tr>
<tr>
<td><form method ="post" action="/Treasure/S/adminGradeUpDown.do" name = "userGradeForm">
<input type = "radio" name = "grade" id="dia" value = "dia"/><label for="dia">dia</label>
<input type = "radio" name = "grade" id="gold" value = "gold"/><label for="gold">gold</label>
<input type = "radio" name = "grade" id="silver" value = "silver"/><label for="silver">silver</label>
<input type = "radio" name = "grade" id="bronze" value = "bronze"/><label for="bronze">bronze</label>
<input type = "radio" name = "grade" id="blackList" value = "blackList"/><label for="blackList">blackList</label>
<input type = "hidden" name = "user_id" value = "${udb.user_id}">
<script>check();</script>
</td>
</tr>

<tr>
<td colspan = "2" style = "text-align: center">BlackList 등록 사유(BlackList 등록 시)<br>
<textarea name = "blackListReason" style = "width : 350px; height : 50px;">
</textarea><br>
<input type = "submit" value = "등록" style = "background-color: white; margin-top : 10px;"><input type = "button" onClick = "cancel()" style = "margin-top : 10px; margin-left : 5px; width : 50px; background-color: white;" value="닫기">
</td>
</tr>
</form>
</table>
</body>
</html>