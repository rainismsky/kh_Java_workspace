<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0; url=/MVC_All/logon2/list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
pw가 다르Yo
<br>
<a href="javascript:history.go(-1)">[글 삭제 폼으로 return ㄱㄱ]</a>
</c:if>