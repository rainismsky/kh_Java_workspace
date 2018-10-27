<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />

<script type="text/javascript">

</script>
<title>글쓰기</title>
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
<h5>Community ▶ 자유게시판</h5>
      <b><h3>글내용 보기</h3></b> <br>
      <form>
         <table>
         <tr height="30">
            <th align="center" >${article.b_head}  ${article.b_title}</th>
         </tr>
         <tr>               
            <td align="right"> 글번호 : ${article.b_no} | 조회수 : ${article.b_view} | 작성일 : ${article.b_date}</td>
         </tr>
            
            <tr>
               <td align="center" height = "100%" ><c:if test="${!empty article.b_image }"><img src="${pageContext.request.contextPath}${article.b_image }
             " style="width:500px; height:500px;"></c:if>
             <br><br>${article.b_content}</td>
            </tr>
            
         </table>
         <td ><br>
               <input type="button" value="글수정" onclick="document.location.href='/Treasure/K/fbupdateForm.do?b_no=${article.b_no}&pageNum=${pageNum}'">
               <input type="button" value="글목록" onclick="document.location.href='/Treasure/K/fblist.do?pageNum=${pageNum}'">
               <c:if test="${article.user_id == user_id}">
               <input type="button" value="글삭제" onclick="document.location.href='/Treasure/K/fbdeletePro.do?b_no=${article.b_no}&pageNum=${pageNum}'"></c:if>
         </td>
         
      </form>
      </div>
<%-- 
<div class="comment">
<hr>
<div class="comment-font"> Comment</div>
<hr>
<form method="post" name="commentform" action="/Treasure/J/lcommentPro.do" onsubmit="return writeSave()" onclick="return loginck()">
<input type="hidden" name = "show_no" value = "${sdb.show_no}">
<input type="hidden" name = "user_id" value = "${sdb.user_id}">
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="5" rowspan="2">
		<textarea id="content" name="content" rows="5" cols="90" maxlength="99" style="width: 700px"></textarea>
		</td>
		<td>
		<input type="submit" value="답글달기"><br>
		</td>
	</tr>
	<tr>
		<td align="right">
		<span id="counter"></span>
		</td>
	</tr>
</table>
</form> --%>
<%-- 
<c:forEach var="lcomm" items="${lcommentList }">
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center" height="80" style="background-color: #EAEAEA; margin-bottom: 10px;">
	<tr>
		<td width="100" align="center" style="font-weight: bold;">
		<img class="photo" src="${pageContext.request.contextPath}${lcomm.comm_user_photo}" style="width:40px"><br>
		${lcomm.comm_user_id }
		</td>
		<td width="500">
		${lcomm.l_comm_content }
		</td>
		<td width="200" align="right">
		<fmt:formatDate value="${lcomm.l_comm_date}" pattern="yyyy-MM-dd, HH:mm:ss"/> &nbsp;
		</td>
	</tr>
</table>
</c:forEach> --%>
</body>
</html>
