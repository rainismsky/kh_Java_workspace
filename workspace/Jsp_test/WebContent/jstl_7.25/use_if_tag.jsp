<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>if 태그를 써보도록 하자 효댕아</title>
</head>

<body>
<c:if test="true">
무조건 수행<br>
</c:if>

<c:if test="${param.name == 'bk'}">
name 파라미터 값이 ${param.name}임.<br>
</c:if>

<c:if test="${28 < param.age}">
우리 효댕이 며짤? 이시팔쨜!!
</c:if>

</body>
</html>