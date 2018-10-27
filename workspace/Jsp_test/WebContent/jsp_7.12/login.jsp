<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String id = request.getParameter("memberId");
    if(id.equals("test123")){
    	response.sendRedirect("index.jsp");
    	}else{
%>
    		
<html>
<head>
<title>로그인 실패</title>
</head>
<body>
잘못된 ID다.
</body>
</html>
<%
}
%>