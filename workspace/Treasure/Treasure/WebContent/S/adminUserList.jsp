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
<script>

/* function goGrade(form){
	   // url과 사용자 입력 id를 조합합니다.
	 url = "/Treasure/S/adminUserDetail.do?user_id="+document.form.user_id.value;	 
	 // 새로운 윈도우를 엽니다.
	 window.open(url, "detail", 
	 "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700;, height=700;");
	 return false;
} */

function goDetail(form) {
	window.open('about:blank','Detail','width=600,height=700');
	form.submit();
	}

function openwin(form) {
	window.open('about:blank','grade2','width=600,height=700');
	form.submit();
	}

</script>
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
<h3>Admin ▶ 회원리스트</h3>
<table style = "border: 1px solid; width: 840px; max-height : 400px; text-align: center;">
<tr style = "background-color: gray; text-align: center; max-height : 50px;">
<td style = "background-color: gray; color : white; width : 100px;">ID
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">등급
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">이름
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 200px;">가입일
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">세부정보
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">등급관리
</td>
</tr>
<c:if test="${userListSize eq 0 && searchOk ne 'y'}">
<tr>
<td colspan = "5">
현재 가입 된 회원이 없습니다.
<td>
</tr>
</c:if>
<c:if test="${userListSize eq 0 && searchOk eq 'y'}">
<tr>
<td colspan = "5" >
해당하는 검색 결과가 없습니다.
<td>
</tr>
</c:if>
 <c:forEach var="userList" items="${userList}" varStatus="status">
<c:if test="${status.count%2 eq 1}"> 
<tr style = "background-color: Lightgray;">
<td style = "background-color: Lightgray;">${userList.user_id}
</td>
<td style = "background-color: Lightgray;">${userList.user_grade}
</td>
<td style = "background-color: Lightgray;">${userList.user_name}
</td>
<td style = "background-color: Lightgray;">${userList.user_date}
</td>
<td style = "background-color: Lightgray;"><form style = "margin-bottom : 0px;" method = "post" target ="Detail" action = "/Treasure/S/adminUserDetail.do"><input type = "button" value = "상세보기" onClick ="goDetail(this.form)">
<input type = "hidden" name = "user_id" value = "${userList.user_id}"></form>
</td>
<td style = "background-color: Lightgray;"><form method = "post" target = "grade2" action="/Treasure/S/adminUserGradeForm.do" style = "margin-bottom : 0px;">
<input type = "button" value="이동" size="10" onClick = "openwin(this.form)"><input type = "hidden" name = "user_id" value = "${userList.user_id}"></form>
</td>
</tr>
 </c:if> 
<c:if test="${status.count%2 eq 0}">
<tr style = "background-color: beige;">
<td style = "background-color: beige;">${userList.user_id}
</td>
<td style = "background-color: beige;">${userList.user_grade}
</td>
<td style = "background-color: beige;">${userList.user_name}
</td>
<td style = "background-color: beige;">${userList.user_date}
</td>
<td style = "background-color: beige;"><form style = "margin-bottom : 0px;" method = "post" target ="Detail" action = "/Treasure/S/adminUserDetail.do"><input type = "button" value = "상세보기" onClick ="goDetail(this.form)">
<input type = "hidden" name = "user_id" value = "${userList.user_id}"></form>
</td>
<td style = "background-color: beige;"><form method = "post" target = "grade2" action="/Treasure/S/adminUserGradeForm.do" style = "margin-bottom : 0px;">
<input type = "button" value="이동" size="10" onClick = "openwin(this.form)"><input type = "hidden" name = "user_id" value = "${userList.user_id}"></form>
</td>
</tr>
</c:if>
 </c:forEach> 
</table>
<div style = "float : left; margin-left : 380px;">
<c:if test="${count > 0}">
<c:if test="${searchOk ne 'y'}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/adminUserList.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/adminUserList.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/adminUserList.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
   </div>
   <div style = "margin-top : 30px;">
   <form method = "post" name = "Search" action="/Treasure/S/adminUserSearch.do" style = "height : 27px;">
   <select name = "category" style = "margin-top : 1px; margin-left : 250px; border : 1px solid gray; height : 26px;">
   <option value = "이름">이름</option>
   <option value = "등급">등급</option>
   <option value = "ID">ID</option>
   </select>
   <input type = "search" name = "userSearch" style = "margin-right : 5px; height : 27px; "><input type = "submit" value = "검색" style = "background-color: white; margin-right : 10px;">
   <input type = "hidden" name = "searchOk" value = "y">
   </form>
   </div>
</c:if>
<c:if test="${searchOk eq 'y'}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/adminUserSearch.do?pageNum=${startPage - 10 }&searchOk=y&category=${category}&userSearch=${userSearch}">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/adminUserSearch.do?pageNum=${i}&&searchOk=y&category=${category}&userSearch=${userSearch}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/adminUserSearch.do?pageNum=${startPage + 10}&searchOk=y&category=${category}&userSearch=${userSearch}">[다음]</a>
   </c:if>
   </div>
   <div style = "margin-top : 30px;">
   <form method = "post" name = "Search" action="/Treasure/S/adminUserSearch.do" style = "height : 27px;">
   <select name = "category" style = "margin-top : 1px; margin-left : 250px; border : 1px solid gray; height : 26px;">
   <option value = "이름">이름</option>
   <option value = "등급">등급</option>
   <option value = "ID">ID</option>
   </select>
   <input type = "text" name = "userSearch" style = "margin-right : 5px; height : 27px;" value = "${userSearch}"><input type = "submit" value = "검색" style = "background-color: white; margin-right : 10px;">
   <input type = "hidden" name = "searchOk" value = "y">
   </form>
   </div>
</c:if>
</c:if>
</div>
</body>
</html>