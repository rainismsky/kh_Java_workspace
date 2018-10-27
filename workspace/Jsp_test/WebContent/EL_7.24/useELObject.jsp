<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
	request.setAttribute("name","이름");
	session.setAttribute("name","이름");
	pageContext.setAttribute("name","page");
%>

<html>
<head>
<title>EL Object</title>
</head>

<body>
${name} <br>
요청 URI : ${pageContext.request.requestURI}<br>
request의 name속성 : ${requestScope.name}<br>
code 파라미터 : ${param.code == null}

</body>
</html>