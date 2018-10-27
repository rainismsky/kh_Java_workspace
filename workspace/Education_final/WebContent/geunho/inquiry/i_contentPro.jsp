<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0; url=/Education/geunho/inquiry/i_deleteForm.do?pageNum=${pageNum}">
</c:if>
<c:if test="${check==0}">

<br>
<a href="javascript:history.go(-1)">[WriteDelete Form => return ÇÕ´Ï´Ù]</a>
</c:if>