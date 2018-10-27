<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %> <%-- 자바 스크립트 문장 쓰기 위해 사용 --%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="user" class="user.User1" scope="page"/> 
<jsp:setProperty name="user" property="userID"/>
<jsp:setProperty name="user" property="userPassword"/>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>보.석</title>
</head>
<body>
<%
String userID = null;
if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
	
}
	if(userID != null){
	PrintWriter script = response.getWriter(); 
	script.println("<script>");
	script.println("alert('이미 로그인 중 입니다.')");
	script.println("location.href = 'main.jsp'");
	script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
	script.println("</script>");
	
}

UserDAO userDAO = new UserDAO();
int result = userDAO.login(user.getUserID(),user.getUserPassword());
if(result == 1){
	session.setAttribute("userID",user.getUserID());	
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href = 'main.jsp'");
	script.println("</script>");
}
else if(result == 0){
	PrintWriter script = response.getWriter(); 
	script.println("<script>");
	script.println("alert('pw가 틀립니다.')");
	script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
	script.println("</script>");
}
else if(result == -1){
	PrintWriter script = response.getWriter(); 
	script.println("<script>");
	script.println("alert('ID가 존재하지 않습니다.')");
	script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
	script.println("</script>");
}		
else if(result == -2){
		PrintWriter script = response.getWriter(); 
		script.println("<script>");
		script.println("alert('DB 오류가 발생 했습니다.')");
		script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
		script.println("</script>");
}
%>

</body>
</html>