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
<h3>Admin ▶ 좋아요 순위</h3>
<table style = "border: 1px solid; width: 840px; max-height : 400px; text-align: center;">
<tr style = "background-color: gray; text-align: center; max-height : 50px;">
<td style = "background-color: gray; color : white; width : 100px;">카테고리
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 300px;">제목
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">게시자
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">좋아요
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">판매<br>희망 여부
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">경매<br>허가 여부
</td>
</tr>
<c:if test="${likeRankSize eq 0}">
<tr>
<td colspan = "5">
현재 누적 좋아요 수 100 이상인 작품이 없습니다.
<td>
</tr>
</c:if>
 <c:forEach var="likeRankList" items="${likeRankList}" varStatus="status">
<c:if test="${status.count%2 eq 1}"> 
<tr style = "background-color: Lightgray;">
<td style = "background-color: Lightgray;">${likeRankList.s_category_name}
</td>
<td style = "background-color: Lightgray;"><a href = "/Treasure/J/show_detail.do?show_no=${likeRankList.show_no}">${likeRankList.show_title}</a>
</td>
<td style = "background-color: Lightgray;">${likeRankList.user_id}
</td>
<td style = "background-color: Lightgray;">${likeRankList.show_like}
</td>
<td style = "background-color: Lightgray;">${likeRankList.show_sale}
</td>
<c:if test="${likeRankList.show_sale eq 'no'}">
<td style = "background-color: Lightgray; color : red;"><h5>경매 불가</h5>
</td>
</c:if>
 <c:if test="${likeRankList.show_auction_ok eq 'O'}"> 
<td style = "background-color: Lightgray;"><h5 style = "margin-bottom : 0px;">허가 완료</h5>
</td>
 </c:if> 
 <c:if test="${likeRankList.show_auction_ok ne 'O' && likeRankList.show_sale eq 'yes'}"> 
<td style = "background-color: Lightgray;"><form action="/Treasure/S/auctionAllow.do" style = "margin-bottom : 0px;">
<input type = "submit" value="경매허가" size="10"><input type = "hidden" name = "show_no" value = "${likeRankList.show_no}"><input type = "hidden" name = "user_id" value = "${likeRankList.user_id}"></form>
</td>
 </c:if> 
</tr>
 </c:if> 
<c:if test="${status.count%2 eq 0}">
<tr style = "background-color: beige;">
<td style = "background-color: beige;">${likeRankList.s_category_name}
</td>
<td style = "background-color: beige;"><a href = "/Treasure/J/show_detail.do?show_no=${likeRankList.show_no}">${likeRankList.show_title}</a>
</td>
<td style = "background-color: beige;">${likeRankList.user_id}
</td>
<td style = "background-color: beige;">${likeRankList.show_like}
</td>
<td style = "background-color: beige;">${likeRankList.show_sale}
</td>
<c:if test="${likeRankList.show_sale eq 'no'}">
<td style = "background-color: beige; color : red;"><h5>경매 불가</h5>
</td>
</c:if>
 <c:if test="${likeRankList.show_auction_ok eq 'O'}"> 
<td style = "background-color: beige;"><h5 style = "margin-bottom : 0px;">허가 완료</h5>
</td>
 </c:if> 
 <c:if test="${likeRankList.show_auction_ok ne 'O' && likeRankList.show_sale eq 'yes'}"> 
<td style = "background-color: beige;"><form action="/Treasure/S/auctionAllow.do" style = "margin-bottom : 0px;">
<input type = "submit" value="경매허가" size="10"><input type = "hidden" name = "show_no" value = "${likeRankList.show_no}"><input type = "hidden" name = "user_id" value = "${likeRankList.user_id}"></form>
</td>
 </c:if> 
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
        <a href="/Treasure/S/adminLike.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/adminLike.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/adminLike.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</c:if>
</div>
</div>
</body>
</html>