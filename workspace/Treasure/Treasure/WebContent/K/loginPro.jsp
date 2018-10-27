<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
    <c:set var="memId" value="${user_id}" scope="session"/>
    <meta http-equiv="Refresh" content="0;url=/Treasure/J/main.do" />
    <script>
    window.opener.location.reload();    //부모창 reload


    window.close();    //현재 팝업창 Close
    </script>
</c:if>
<c:if test="${check==0}">
	<script> 
	  alert("비밀번호가 맞지 않습니다.");
      history.go(-1);
	</script>
</c:if>
<c:if test="${check==-1}">
	<script>
	  alert("아이디가 맞지 않습니다..");
	  history.go(-1);
	</script>
</c:if>