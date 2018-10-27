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
		<h5>My Page ▶ 좋아요 / 북마크 ▶ 북마크</h5>
		<div class="likee" style="height: 400px;">
			<div style="position: relative; float: left;"><img src="../images/paintedDiaBox.png" style="width:50px;"></div>
			<div style="position: relative; float:left; font-size: 37px;">북마크</div>
				<div style="position: absolute; top: 130px;">
				<hr style="width: 850px; position: absolute;">
				<br><br>
				<c:set var="i" value="0" />
				<c:set var="j" value="3" />
				<table border="0" height="260px" cellpadding="0" cellspacing="0"">
				<c:if test="${bookmarkList eq null }">
				북마크 한 전시가 없습니다.
				</c:if>
				<c:forEach var="bookk" items="${bookmarkList }">
				<c:if test="${i%j == 0}">
				<tr>				
				</c:if>
				<td width="283px" style="padding: 20px 20px;">
				<a href = "/Treasure/J/show_detail.do?show_no=${bookk.show_no}&&user_id=${bookk.user_id}">
				<img src="${pageContext.request.contextPath}${bookk.show_image}" style="width:220px; height: 230;">
				<br>
				<div style=" position: relative; float: left;"><font size="3px" >${bookk.show_title }</font></div>
				<div style=" position: relative; right: 25px; float: right;"><img src="../images/painteddia.png" style="width:20px;">${bookk.countedLike } </div>
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
	</div>
</div>
</body>
</html>