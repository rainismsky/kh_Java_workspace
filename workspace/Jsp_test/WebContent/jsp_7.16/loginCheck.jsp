<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "util.Cookies" %>

<%
	 Cookies cookies = new Cookies(request);
%>

<html>

<head><title>로그인여부 검사</title></head>

<body>

<% 
if(cookies.exists("AUTH")){ 
%>

ID"<%= cookies.getValue("AUTH") %>"로 로그인 한 상태
<%
}else{
%>
미 로그인 상태
<% 
	}
%>
</body>
</html>
