<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<c:set var="memId" value="${id}" scope="session"/>
<meta http-equiv="Refresh" content="0;url=/MVC_All/logon2/main.do"/>
</c:if>
<c:if test="${check==0}">
<script>
alert("pw가 맞지 않다.");
history.go(-1);
</script>
</c:if>

<c:if test="${check==-1}">
<script>
alert("ID가 안 맞다");
history.go(-1);
</script>
</c:if>

=======================================================logout