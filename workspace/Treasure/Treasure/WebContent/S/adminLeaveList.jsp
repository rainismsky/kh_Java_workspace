<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
<link href="${pageContext.request.contextPath}/css/head.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<title>Admin</title>
</head>
<body>
<tiles:insertDefinition name="header_admin" />
<tiles:insertDefinition name="menu_admin" />
<div class = "right2" style = "margin-top : 20px;">
<h3>Admin ▶ 탈퇴리스트</h3>
<table style = "border: 1px solid; width: 840px; max-height : 400px; text-align: center;">
<tr style = "background-color: gray; text-align: center; max-height : 50px;">
<td style = "background-color: gray; color : white; width : 100px;">등급
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">생년월일
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 70px;">성별
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 150px;">탈퇴일
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 420px;">탈퇴 사유
</td>

</tr>
<c:if test="${leaveListSize eq 0}">
<tr>
<td colspan = "5">
현재 탈퇴리스트에 등록된 사용자가 없습니다.
<td>
</tr>
</c:if>
 <c:forEach var="leaveList" items="${leaveList}" varStatus="status">
<c:if test="${status.count%2 eq 1}"> 
<tr style = "background-color: Lightgray;">
<td style = "background-color: Lightgray;">${leaveList.ul_grade}
</td>
<td style = "background-color: Lightgray;">${leaveList.ul_birth}
</td>
<td style = "background-color: Lightgray;">${leaveList.ul_gender}
</td>
<td style = "background-color: Lightgray;"><fmt:formatDate value="${leaveList.ul_date}" pattern="yyyy-MM-dd"/> 
</td>
<td style = "background-color: Lightgray;">${leaveList.ul_reason}
</td>
</tr>
 </c:if> 
<c:if test="${status.count%2 eq 0}">
<tr style = "background-color: beige;">
<td style = "background-color: beige;">${leaveList.ul_grade}
</td>
<td style = "background-color: beige;">${leaveList.ul_birth}
</td>
<td style = "background-color: beige;">${leaveList.ul_gender}
</td>
<td style = "background-color: beige;">${leaveList.ul_date}
</td>
<td style = "background-color: beige;">${leaveList.ul_reason}
</td>

</tr>
</c:if>
 </c:forEach> 
</table>
<div style = "float : left; margin-left : 380px;">
<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/adminLeaveList.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/adminLeaveList.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/adminLeaveList.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>
</div>
</div>
</body>
</html>