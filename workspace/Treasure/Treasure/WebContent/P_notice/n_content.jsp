<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<title>공지사항</title>
<link href="style.css" rel="stylesheet" type="text/css">

<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
	
<style>
body{font-family: 'Do Hyeon', sans-serif;}
table {
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

<body >

<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
<tiles:insertDefinition name="menu_comu" />
<div class= "right2" style="font-family: 'Do Hyeon', sans-serif;" >
<h5>Community ▶ 공지사항 </h5>
		<b>글내용 보기</b> <br><br>
		<form>
			<table >
			<tr height="30">
				<th align="center" >${article.n_title}</th>
			</tr>
			<tr>					
				<td align="right"> 글번호 : ${article.n_no} | 조회수 : ${article.n_view} | 작성일 : ${article.n_date}</td>
			</tr>
				
				<tr>
					<td height = "400px;" valign="top">${article.n_content}</td>
				</tr>
				
			</table>
			<c:if test="${sessionId eq 'admin'}">
					<input type="button" value="글수정" onclick="document.location.href='/Treasure/P_notice/n_updateForm.do?n_no=${article.n_no}&pageNum=${pageNum}'">
					<input type="button" value="글삭제" onclick="document.location.href='/Treasure/P_notice/n_deleteForm.do?n_no=${article.n_no}&pageNum=${pageNum}'">
			</c:if>
			
		</form>
		</div>
</body>
</html>