<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/MVC_All/MVC/list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
비.번.틀.림 !!!
<br>
<a href="javascript:history.go(-1)">[글 수정 폼으로 돌아가기]</a>
</c:if>