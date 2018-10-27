<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>게시판</title>

<!-- <link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script> -->

</head>

<body> 
<b>글수정</b>
<br>
<form method="post" name="writeform" action="/Education/geunho/notice/updatePro.do?pageNum=${pageNum}" onsubmit="return writeSave()">
<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">

  <tr>
    <td width="70" align="center" >글 제목</td>
    <td align="left" width="330">
       <input type="text" size="40" maxlength="50" name="n_subject" value="${article.n_subject}"></td>
  </tr>
  <tr>
    <td width="70" align="center" >글 내용</td>
    <td align="left" width="330">
     <textarea name="n_content" rows="20" cols="50">${article.n_content}</textarea></td>
  </tr>
 
  <tr>     
   <td colspan=2  align="center">
     <input type="submit" value="글수정" > 
     <input type="reset" value="다시작성">
     <input type="button" value="목록보기" onclick="document.location.href='/Education/geunho/notice/Notice.do?pageNum=${pageNum}'">
   </td>
</tr>
</table>
</form>
</body>
</html>     