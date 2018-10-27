<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="show_style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Concert+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Concert+One|Libre+Baskerville:700" rel="stylesheet">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<div class="page">
<tiles:insertDefinition name="header"/> 
<tiles:insertDefinition name="menu_m" />
<div class="right2">
<h5>My Page ▶ 나의 팔로잉 </h5>
<h2>나의 팔로잉</h2>
<font size="3px"><strong>'${sessionId}'</strong></font><font size="2px"> 님이 팔로우한 유저의 전시를 랜덤으로 보여드립니다.</font>
<hr style="width: 850px; position: absolute;">
<h2></h2>
<c:set var="i" value="0" />
<c:set var="j" value="3" />
<table border="0"  height="260px" cellpadding="0" cellspacing="0"">
<c:if test="${followingList eq null }">
팔로잉한 유저 또는 전시가 없습니다.
</c:if>
<c:forEach var="follow" items="${followingList }">
<c:if test="${i%j == 0}">
<tr>
</c:if>
<td width="283px;" style="padding: 20px 20px;">
<a href = "/Treasure/J/show_detail.do?show_no=${follow.show_no}&&user_id=${follow.user_id}">
<img src="${pageContext.request.contextPath}${follow.show_image}" style="width:220px; height: 230;">
<br>
<div style=" position: relative; float: left;"><font size="4px" >${follow.show_title }</font></div>
<div style=" position: relative; right: 25px; float: right;"><strong>${follow.user_id }</strong></div> <br> 
</a>
</td>
<c:if test="${i%j == j-1 }">
</tr>
</c:if>
<c:set var="i" value="${i+1 }"/>
</c:forEach>

</table>

</div>
</div>
</body>
</html>