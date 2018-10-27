<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>choose 태그를 써보도록 하자 효댕아!</title>
</head>

<body>

<ul>
<c:choose>
<c:when test="${param.name == 'bk'}">
<li> 니 이름은 ${param.name}임.
</c:when>

<c:when test="${param.age >= 20}">
<li>당신은 20 이상임

</c:when>
<c:otherwise>
<li>당신은 'bk'가 아니고 20이상이 아님.

</c:otherwise>
</c:choose>
</ul>
</body>
</html>