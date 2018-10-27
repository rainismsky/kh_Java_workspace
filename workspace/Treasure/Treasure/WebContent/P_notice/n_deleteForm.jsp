
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>



<html>
<head>
<title>공지사항</title>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
	
<style>
body{font-family: 'Do Hyeon', sans-serif;}
table {
    width: 500px;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    border-color : #e8e8e8;
    width:1000px;
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
<div class= "right2" >
<h5>Community ▶ 공지사항 </h5>
		<b>글삭제</b> <br>
		<form method="POST" name="delForm" action="/Treasure/P_notice/n_deletePro.do?pageNum=${pageNum}"
			onsubmit="return deleteSave()">
			<input type="hidden" name="n_no" value="${n_no}">
			
			<table border="1" cellspacing="0" cellpadding="0" width="360">
				
				
				
				<tr height="30">
					<td align=center >
					<input type="submit" value="글삭제">
					<input type="button" value="돌아가기" onclick="document.location.href='/Treasure/P_notice/n_list.do?pageNum=${pageNum}'">
					</td>
				</tr>
			</table>
		</form>
		</div>
</body>



</html>
