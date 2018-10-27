<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page impoty = "java".utill.Calender" %>

<html>
<head>

<title>현재 시간</title>
</head>
<body>

<%
	Calender  cal = (Calendar)request.getAttribute("time");
%>

현재 시간은 <%= cal.get(Calendar.HOUR) %>시
			<%= cal.get(Calendar.MINUTE) %>분
			<%= cal.get(Calendar.SECOND) %>초 입니다.
</body>

</body>
</html>