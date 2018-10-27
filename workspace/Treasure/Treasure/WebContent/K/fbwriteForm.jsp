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
  
  var loadFile = function(event) {
      var output = document.getElementById('output');
      output.src = URL.createObjectURL(event.target.files[0]);
    };

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
<h5>Community ▶ 자유게시판 </h5>
<b><h3>글쓰기</h3></b>
<br>
<form class="form-horizontal" method="post" enctype="Multipart/form-data"
        action="/Treasure/K/fbwritePro.do" name="userinput" onSubmit="return checkIt()">
<table width="400" border="1" cellspacing="0" cellpadding="0">
  
       <input type="hidden" name="b_no" value="${b_no}">
      <input type="hidden" name="b_category" value="1">
      <input type="hidden" name="user_id" value="${user_id}">
  <tr>
             <td>머릿말</td>
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
       <input type="text" size="70" maxlength="50" name="b_title"></td>
  </tr>
  
  <tr>
    <td  width="70"  bgcolor="${value_c}" align="center" >내 용</td>
    <td align="left" width="330">
     <textarea name="b_content" rows="13" cols="80"></textarea></td>
  </tr>
  <tr>
             <td>사진첨부</td>
             <td><input type="file" name="b_image" accept="image/*" width="200" height="200" onchange="loadFile(event)">
<img id="output" width="200" height="200"/></td>
          </tr>
          
          
          
          
          
          
          
          
  <tr>     
   <td colspan=2 bgcolor="${value_c}" align="center">
     <input type="submit" value="글쓰기" > 
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기"
       onclick="location.href='/Treasure/K/fblist.do'">
   </td>
</tr>
</table>
</form>


</div>



</body>
</html>
