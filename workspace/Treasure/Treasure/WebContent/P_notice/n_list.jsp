<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>




<!DOCTYPE html>
<html>
<head>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<meta charset="UTF-8">
<title>공지사항</title>
<style>
body{font-family:}
table {
   /*  width: 500px; */
    border-top: 1px solid #444444;
    border-collapse: collapse;
    border-color : #e8e8e8;
    width:700px;
    cellpadding:0;
    cellspacing:0;

    
  }
  th, td {
    border-bottom: 1px solid #e8e8e8;
    padding: 10px;
    border-color : #e8e8e8;
    
  }
 th{
 	background-color: #f2eee8;
 }
  a{
  	text-decoration:none;
  	color : black;
  }
  a:hover{
  	color: #657c6b;
  }

</style>
</head>
<body>

<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
<tiles:insertDefinition name="menu_comu" />
<div class= "right2" style="font-family: 'Do Hyeon', sans-serif;" >
<h5>Community ▶ 공지사항 </h5>
	<right><b>(전체 글:${count})</b></right>

	<!-- 전체 글의 개수  -->
	<c:if test="${count == 0}">

		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">공지사항이 없습니다.</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${sessionId eq 'admin'}">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<right><a href="/Treasure/P_notice/n_writeForm.do">글쓰기</a></right>
	</c:if>
	
	
	<c:if test="${count > 0}">
	 
		<table>
			<tr height="30">
				<th align="center" width="50">번 호</td>
				<th align="center" width="80">제 목</td>
				<th align="center" width="50">조회수</td>
				<th align="center" width="80">날 짜</td>


			</tr>

			<c:forEach var="article" items="${articleList}">
				<tr height="30">
					<td align="center"><c:out value="${article.n_no}" /> <c:set
							var="number" value="${n_no - 1}" /></td>
					<td><a
						href="/Treasure/P_notice/n_content.do?n_no=${article.n_no}&pageNum=${currentPage}">
							${article.n_title} </a></td>

					<td align="center">${article.n_view}</td>
					<td align="center"><c:out value="${article.n_date}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
<!-- paging -->
<div align="left">
	<c:if test="${count > 0}">
		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${10}" />
		<fmt:parseNumber var="result" value="${currentPage / 10}"
			integerOnly="true" />
		<c:set var="startPage" value="${result * 10 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > 10}">
			<a href="/Treasure/P_notice/n_list.do?pageNum=${startPage - 10 }">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="/Treasure/P_notice/n_list.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="/Treasure/P_notice/n_list.do?pageNum=${startPage + 10}">[다음]</a>
		</c:if>
	</c:if>
</div>
</div>
</body>
</html>