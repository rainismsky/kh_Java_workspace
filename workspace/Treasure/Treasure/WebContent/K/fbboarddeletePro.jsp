<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/Treasure/K/fblist.do?pageNum=${pageNum}" >
</c:if>
<c:if test="${check==0}">
글작성자만 삭제할 수 있습니다.
<br>
<a href="javascript:history.go(-1)">[글삭제 폼으로 돌아가기]</a>
</c:if>