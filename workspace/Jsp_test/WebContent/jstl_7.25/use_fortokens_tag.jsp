<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<title>forTokens 태그</title>
</head>

<body>
콤마(,) , 점(.) 구분자로 사용: <br>

<c:forTokens var="token" items="빨강,주황,노랑,초록,파랑,남,보라(색)" delims=",.">
${token}
</c:forTokens>

</body>
</html>