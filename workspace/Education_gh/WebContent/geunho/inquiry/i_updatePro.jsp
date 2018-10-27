<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/Education/geunho/inquiry/inquiry_list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">

이게 무어신가
<br>
<a href="javascript:history.go(-1)">[글 수정 폼으로 돌아가기]</a>
</c:if>