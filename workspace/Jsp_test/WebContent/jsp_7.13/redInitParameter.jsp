<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.util.Enumeration" %>

<html>
<head>

<title>초기화 파라미터 읽어오기</title>
</head>
<body>

초기화 파라미터 LIST:
<ul>
<%
	Enumeration initParamEnum = application.getInitParameterNames();
	while (initParamEnum.hasMoreElements()){
		String initParamName = (String)initParamEnum.nextElement();
%>
<li><%= initParamName %> =
	<%= application.getInitParameter(initParamName) %>
<%
	}
%>


</ul>


</body>
</html>