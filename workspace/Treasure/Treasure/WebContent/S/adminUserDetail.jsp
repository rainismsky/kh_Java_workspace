<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<table style = "border : 1px solid; width : 500px; height : 600px; margin : 0 auto;">
<tr style = "border-bottom: 1px;">
<td colspan = "2"><h2>회원정보</h2>
</td>
<td>
<form method = "post" action = "/Treasure/K/modifyForm.do" name = "modify">
<input type = "submit" value = "정보수정" style = "background-color:  white;"><input type = "hidden" name="user_id" value = "${udb.user_id}"></form>
</td>
<td>
<form method = "post" action = "/Treasure/S/adminSendMessageForm.do" name = "message">
<input type = "submit" value = "쪽지전송" style = "background-color:  white;"><input type = "hidden" name="user_id" value = "${udb.user_id}"></form>
</td>
<td>
<form method = "post" action = "/Treasure/S/adminUserGradeForm.do" name = "grade">
<input type = "submit" value = "등급관리" style = "background-color:  white;"><input type = "hidden" name="user_id" value = "${udb.user_id}"></form>
</td>
</tr>
<tr>
<td style = "width : 100px;">아이디
</td>
<td>${udb.user_id}
</td>
<td colspan = "3" rowspan = "5" style = "text-align: center;"><img src="${pageContext.request.contextPath}${udb.user_photo}" width="200px;"/><br>좋아요(누적)<br>${udb.total_like}
</td>
</tr>
<tr>
<td>이름
</td>
<td>${udb.user_name}
</td>
<td colspan = "3">
</td>
</tr>
<tr>
<td>이메일
</td>
<td>${udb.user_email}
</td>
<td colspan = "3">
</td>
</tr>
<tr>
<td>휴대전화
</td>
<td>${udb.user_phone}
</td>
<td colspan = "3">
</td>
</tr>
<tr>
<td>성별
</td>
<td>${udb.user_gender}
</td>
<td colspan = "3">
</td>
</tr>
<tr>
<td>등급
</td>
<td>${udb.user_grade}
</td>
<td rowspan ="2" style = "text-align: center;">팔로워<br>${udb.total_follower}
</td>
<td rowspan ="2" style = "text-align: center;">팔로잉<br>${udb.total_following}
</td>
<td rowspan ="2" style = "text-align: center;">게시물 수<br>${udb.total_post}
</td>
</tr>
<tr>
<td>생년월일
</td>
<td>${udb.user_birth}
</td>
</tr>
<tr>
<td>가입일
</td>
<td colspan = "4"> ${udb.user_date}
</td>
</tr>
<tr>
<td>관심작품
</td>
<td colspan = "4"> ${udb.user_con1}, ${udb.user_con2}, ${udb.user_con3}
</td>
</tr>
<tr>
<td>작가소개
</td>
<td colspan = "4">${udb.user_introduction}
</td>
</tr>
<tr>
<td>
</td>
<td colspan = "4">
</td>
</tr>
</table>

</body>
</html>