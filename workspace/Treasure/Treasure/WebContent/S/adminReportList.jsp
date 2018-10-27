<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/head.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<title>Admin</title>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<tiles:insertDefinition name="header_admin" />
<tiles:insertDefinition name="menu_admin" />
<div class = "right2" style = "margin-top : 20px;">
<h3>Admin ▶ 작품신고내역</h3>
<table style = "border: 1px solid; width: 840px; max-height : 400px; text-align: center;">
<tr style = "background-color: gray; text-align: center; max-height : 70px;">
<td style = "background-color: gray; color : white; width : 150px;">카테고리
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 150px;">제목
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 150px;">게시자
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">신고수
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">게시물 삭제
</td>

</tr>
<c:if test="${reportListSize eq 0}">
<tr>
<td colspan = "5">
현재 신고리스트에 등록된 작품이 없습니다.
<td>
</tr>
</c:if>
 <c:forEach var="reportList" items="${reportList}" varStatus="status">
<c:if test="${status.count mod 2 ne 0}"> 
<tr style = "background-color: Lightgray; max-height : 50px;" >
<td style = "background-color: Lightgray;">${reportList.l_category_name}
</td>
<td style = "background-color: Lightgray;"><a href = "/Treasure/J/show_detail.do?show_no=${reportList.show_no}&&user_id=${reportList.user_id}">${reportList.show_title}</a>
</td>
<td style = "background-color: Lightgray;">${reportList.user_id}
</td>
<td style = "background-color: Lightgray;">${reportList.show_report}
</td>
<td style = "background-color: Lightgray;"><form method = "post" action="/Treasure/S/adminReportDelete.do" style = "margin-bottom : 0px;">
<input type = "submit" value="삭제" size="10"><input type = "hidden" name = "show_no" value = "${reportList.show_no}"><input type = "hidden" name = "user_id" value = "${reportList.user_id}"></form>
</td>
</tr>
 </c:if> 
<c:if test="${status.count mod 2 eq 0}">
<tr style = "background-color: beige; max-height : 50px;">
<td style = "background-color: beige;">${reportList.l_category_name}
</td>
<td style = "background-color: beige;"><a href = "/Treasure/J/show_detail.do?show_no=${reportList.show_no}&&user_id=${reportList.user_id}">${reportList.show_title}</a>
</td>
<td style = "background-color: beige;">${reportList.user_id}
</td>
<td style = "background-color: beige;">${reportList.show_report}
</td>
<td style = "background-color: beige;"><form method = "post" action="/Treasure/S/adminReportDelete.do" style = "margin-bottom : 0px;">
<input type = "submit" value="삭제" size="10"><input type = "hidden" name = "show_no" value = "${reportList.show_no}"><input type = "hidden" name = "user_id" value = "${reportList.user_id}"></form>
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
        <a href="/Treasure/S/adminReportList.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/adminReportList.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/adminReportList.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>
</div>
</div>
</body>
</html>