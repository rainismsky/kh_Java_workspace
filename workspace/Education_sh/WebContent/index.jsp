<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title></title>
</head>
<body>

<c:set var="id" value="teacherid1" scope="session"/>

<c:choose>
	<c:when test="${fn:contains(id,teacher)}">
		<% response.sendRedirect("/Education/Tpage/teacher_Mypage.do"); %>
	</c:when>
	<c:when test="${fn:contains(id,admint)}">

	</c:when>
	<c:otherwise>
		<% response.sendRedirect("/Education/Mypage/users_Mypage.do"); %>
	</c:otherwise>
</c:choose>
</body>
</html>


