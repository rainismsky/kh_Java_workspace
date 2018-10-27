<%@ page contentType="text/html; charset=utf-8" %>
<link href="show_style.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<div class="page">
<c:if test="${sessionScope.memId eq 'admin'}">
	<tiles:insertDefinition name="header_admin"/> 
</c:if>
<c:if test="${sessionScope.memId ne 'admin'}">
	<tiles:insertDefinition name="header"/> 
</c:if>
<tiles:insertDefinition name="menu_comu" />
<div class="right2">
<br><br>
<img src="../images/aboutus.jpg" width="850px">
</div>
</div>
</body>
</html>