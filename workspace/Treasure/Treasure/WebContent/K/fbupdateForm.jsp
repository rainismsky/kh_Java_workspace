<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<title>공지사항</title>
<script language="JavaScript" src="script.js"></script>
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
    width:800px;
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
<script type="text/javascript">

<!--이미지 업로드-->
var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };
  function writeSave(){

	  
	  if(document.writeform.b_title.value==""){
	    alert("제목을 입력하십시요.");
	    document.writeform.b_title.focus();
	    return false;
	  }

	  if(document.writeform.b_content.value==""){
	    alert("내용을 입력하십시요.");
	    document.writeform.b_content.focus();
	    return false;
	  }
	         
	 
	  }   
</script>
<body> 
<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
<tiles:insertDefinition name="menu_comu" />
<div class= "right2" >
<h5>Community ▶ 자유게시판 </h5>
<b><h3>글수정</h3></b>
<br>
<form method="post" name="writeform" enctype="Multipart/form-data"
action="/Treasure/K/fbupdatePro.do?pageNum=${pageNum}" onsubmit="return writeSave()">
<table width="400" border="1" cellspacing="0" cellpadding="0">
  
       <input type="hidden" size="10" maxlength="10" name="user_id" value="${article.user_id}">
   	<input type="hidden" name="b_no" value="${article.b_no}">
  <tr>
		 		<td><center>머릿말</center></td>
		 		<td><p class="text-left"><select name = "b_head">
<option value = "[미술]" > [미술] </option>
<option value = "[도자공예]" > [도자공예] </option>
<option value = "[가죽공예]" > [가죽공예] </option>
<option value = "[금속공예]" > [금속공예] </option>
<option value = "[목재공예]" > [목재공예] </option>
<option value = "[유리공예]" > [유리공예] </option>
<option value = "[섬유공예]" > [섬유공예] </option>
<option value = "[미술품]" > [미술품] </option>
<option value = "[장식품]" > [장식품] </option>
<option value = "[음악]" > [음악] </option>
<option value = "[영화]" > [영화] </option>
<option value = "[도서]" > [도서] </option>
<option value = "[게임]" > [게임] </option>
<option value = "[패션]" > [패션] </option>
<option value = "[전자기기]" > [전자기기] </option>
<option value = "[화폐]" > [화폐] </option>
<option value = "[우표]" > [우표] </option>
<option value = "[피규어/프라모델]" > [피규어/프라모델] </option>
</select></p></td>
		 	</tr>  
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >제 목</td>
    <td align="left" width="330">
       <input type="text" size="70" maxlength="50" name="b_title" value="${article.b_title}"></td>
  </tr>
  
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="b_content" rows="13" cols="80">${article.b_content}</textarea></td>
  </tr>
  <tr>
		 		<td>사진첨부</td>
		 		<td><input type="file" name="uploadFile" value="" accept="image/*" width="200" height="200" onchange="loadFile(event)">
<img id="output" src="../${article.b_image}" width="200" height="200"/>
<input type="hidden" name="b_photo" value="${article.b_image}" /></td>
		 	</tr>
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
  <tr>     
   <td colspan=2 bgcolor="${value_c}" align="center">
     <input type="submit" value="글수정" > 
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기"
       onclick="document.location.href='/Treasure/K/fblist.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>
</div>
</body>

</html>     