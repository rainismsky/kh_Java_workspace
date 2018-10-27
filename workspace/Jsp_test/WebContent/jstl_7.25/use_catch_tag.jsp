<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>catch 효댕 태그</title>
</head>

<body>

<c:catch var="ex">
name 파라미터 값 = <%=request.getParameter("name") %><br>
<% if (request.getParameter("name").equals("test")) { %>
${param.name}은 test임.
<% } %>
</c:catch>
<p>
<c:if test="${ex != null}">
warring!! 익셉션이 발생함!<br>
${ex}
</c:if>

</body>
</html>