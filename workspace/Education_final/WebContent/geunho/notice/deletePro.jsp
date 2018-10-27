<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0; url=/Education/geunho/notice/deleteForm.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
PassWord가 틀렸어.
<br>
<a href="javascript:history.go(-1)">[WriteDelete Form => return합니다..]</a>
</c:if>