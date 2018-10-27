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
<h5>My Page ▶ 관심사 추천 </h5>
<h2>관심사 추천</h2>
<font size="2px">내가 관심있어 하는 분야는 '${ldb.user_con1}', '${ldb.user_con2}', '${ldb.user_con3}' 입니다.</font>
<hr style="width: 850px; position: absolute;">

<h2>${ldb.user_con1 }</h2>
<table border="0" height="260px" cellpadding="0" cellspacing="0"">
<tr>
<c:if test="${firstconList eq null }">
등록된 작품이 없습니다.
</c:if>
<c:forEach var="firstcon" items="${firstconList }">
<td width="283px">
<a href = "/Treasure/J/show_detail.do?show_no=${firstcon.show_no}&&user_id=${firstcon.user_id}">
<img src="${pageContext.request.contextPath}${firstcon.show_image}" style="width:220px; height: 230;">
<br>
<div style=" position: relative; float: left;"><font size="3px" >${firstcon.show_title }</font></div>
<div style=" position: relative; right: 60px; float: right;"><img src="../images/painteddia.png" style="width:20px;">${firstcon.countedLike } </div>
</a>
</td>
</c:forEach>
</tr>
</table>

<h2>${ldb.user_con2 }</h2>
<table border="0" height="260px" cellpadding="0" cellspacing="0"">
<tr>
<c:if test="${secondconList eq null }">
등록된 작품이 없습니다.
</c:if>
<c:forEach var="secondcon" items="${secondconList }">
<td width="283px">
<a href = "/Treasure/J/show_detail.do?show_no=${secondcon.show_no}&&user_id=${secondcon.user_id}">
<img src="${pageContext.request.contextPath}${secondcon.show_image}" style="width:220px; height: 230;">
<br>
<div style=" position: relative; float: left;"><font size="3px" >${secondcon.show_title }</font></div>
<div style=" position: relative; right: 60px; float: right;"><img src="../images/painteddia.png" style="width:20px;">${secondcon.countedLike } </div>
</a>
</td>
</c:forEach>
</tr>
</table>

<h2>${ldb.user_con3 }</h2>
<table border="0" height="260px" cellpadding="0" cellspacing="0"">
<tr>
<c:if test="${thirdconList eq null }">
등록된 작품이 없습니다.
</c:if>
<c:forEach var="thirdcon" items="${thirdconList }">
<td width="283px">
<a href = "/Treasure/J/show_detail.do?show_no=${thirdcon.show_no}&&user_id=${thirdcon.user_id}">
<img src="${pageContext.request.contextPath}${thirdcon.show_image}" style="width:220px; height: 230;">
<br>
<div style=" position: relative; float: left;"><font size="3px" >${thirdcon.show_title }</font></div>
<div style=" position: relative; right: 60px; float: right;"><img src="../images/painteddia.png" style="width:20px;">${thirdcon.countedLike } </div> <br>
</a>
</td>
</c:forEach>
</tr>
</table>

</div>
</div>
</body>
</html>