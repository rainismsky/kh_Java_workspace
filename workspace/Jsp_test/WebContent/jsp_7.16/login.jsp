<%@ page contentType = "text/html; charset=utf-8" %>
<%@ page import = "util.Cookies" %>

<%   
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
 	if (id.equals(password)) {
		//ID,PW 일치할시 로그인 성공 처리!
 		response.addCookie(
			Cookies.createCookie("AUTH", id, "/", -1)
 	);
%>
<html>
<head><title>로그인성공</title></head>
<body>

로그인에 성공했습니다.

</body>
</html>
<%
	} else { // 로그인 실패시
%>
<script>
alert("로그인에 실패하였습니다.");
history.go(-1);
</script>
<%
	}
%>