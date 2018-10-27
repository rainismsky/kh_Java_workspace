<%@ page contentType = "text/html; charset=utf-8" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if(id.equals(password)){
		session.setAttribute("MEMBERID", id);
	}
%>
<html>
<title>로그인 성공</title>

<body>

로그인 성공!

</body>
</html>
<%
	} else { // 로그인 실패시
	
%>
<script>
alert("로그인 실패!")
history)-11
</script>