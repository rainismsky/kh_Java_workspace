<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String code = request.getParameter("cpde");
	String viewPageURI = null;
	
	if(code.equals("A")){
		viewPageURI = "viewMoudule/a.jsp";
	}else if (code.equals("B")){
		viewPageURI = "viewMoudule/b.jsp";
	}else if (code.equals("C")){
		viewPageURI = "viewMoudule/c.jsp";
%>

<jsp:forward page="<%= viewPageURI %>"/>


<html>
<head>

<title>Insert title here</title>
</head>
<body>

</body>
</html>