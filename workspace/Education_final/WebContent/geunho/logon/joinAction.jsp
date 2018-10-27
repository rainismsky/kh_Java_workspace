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
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="userGender"/> 
<jsp:setProperty name="user" property="userEmail"/>
  
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

	if(user.getUserID() == null || user.getUserPassword() == null ||user.getUserName() == null 
	|| user.getUserGender() == null || user.getUserEmail() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력 되지 않았습니다.')");
		script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
		script.println("</script>");		
	
	}else{	
		UserDAO userDAO = new UserDAO();
		int result = userDAO.join(user);
		if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 존재하는 ID 입니다.')");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
}
	else {
		session.setAttribute("userID",user.getUserID());
		PrintWriter script = response.getWriter(); 
		script.println("<script>");
		script.println("alert('pw가 틀립니다.')");
		script.println("history.back"); //이전 페이지로 사용자를 돌려보냄
		script.println("</script>");
}		
}
%>

</body>
</html>