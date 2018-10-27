<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    
    
<head><title> 3장 예제 </title></head>
<html>
<title>3장 예제</title>
</head>
<body>

3장의 인덱스 페이지.

<%
	String value = "자바";
	String encodedvalue = URLEncoder.encode(value,"utf-8");
	response.sendRedirect("index.jsp?name="+ encodedvalue);

%>
</body>
</html>