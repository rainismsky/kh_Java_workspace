<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>ㅅㅂ</title>
</head>

<body>
<c:url value="http//search.naver.com/search" var="searchUrl">
<c:param name="w" value="blog"/>
<c:param name="q" value="공원"/>
</c:url>

<ul>
<li>${searchUrl}</li>
<li><c:url value="/use_if_tag.jsp"/></li>
<li><c:url value="./use_if_tag.jsp"/></li>
</ul>


</body>
</html>