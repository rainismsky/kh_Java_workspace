<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page session = "true" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<%
	Date time = new Date();
	SimpleDateFormat formatter =
			new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
%>

<html>
<head>
<title>세션 정보</title>
</head>

<body>
세션ID: <%=session.getId() %> <br>
<% 
	time.setTime(session.getCreationTime());
%>

세션시간 : <%= formatter.format(time)%> <br>
<% 
	time.setTime(session.getLastAccessedTime());
%>

최근접근시간: <%=formatter.format(time)%>
</body>

</html>
