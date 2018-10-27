<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<title>공지사항 글쓰기</title>
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
<b>공지사항 작성 </b>
<br><br>

<form method="post" name="writeform" action="/Treasure/P_notice/n_writePro.do" 
onsubmit="return writeSave()">

<table width="400" border="1" cellspacing="0" cellpadding="0"  >
  <tr>
    <td  width="70"  align="center" >제 목 </td>
    <input type="hidden" name="n_no" value="${n_no}">
    <td  width="330"> 
     <input type="text" size="40" maxlength="50" name="n_title"></td>
  </tr>

  <tr>
    <td  width="70"  align="center" >내 용</td>
    <td  width="330" >
    <textarea name="n_content" rows="20" cols="80" style = "resize:none">${article.n_content}</textarea></td>
  </tr>
 
  
  <input type="hidden" size="8" maxlength="12" name="n_date">

  
<tr>     
<td colspan=2  align="center">
  <input type="submit" value="글쓰기" > 
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/Treasure/P_notice/n_list.do'">
</td></tr></table>   
</form>  
</div>   
</body>
</html>  