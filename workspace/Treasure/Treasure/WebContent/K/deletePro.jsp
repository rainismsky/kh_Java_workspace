<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<c:if test="${check==1}">
<c:remove var="memId" scope="session"/>
<form method="post" action="/Treasure/J/main.do" name="userinput" >
	<script>
	 alert("회원탈퇴가 정상적으로 처리되었습니다.");
	</script>
      <meta http-equiv="Refresh" content="0;url=/Treasure/J/main.do" >
    
</form>
</c:if>

<c:if test="${check==0}">
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
</c:if>

</body>
</html>