<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/Education/geunho/notice/Notice.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">
뭔가 잘 못 되어도 한참 잘 못 되었다..
<br>
<a href="javascript:history.go(-1)">[글 수정 폼으로 돌아가기]</a>
</c:if>