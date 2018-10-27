<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script>          
function deleteSave(){
if(document.delForm.n_readcount.value==''){
alert("를 입력하십시요.");
document.delForm.n_readcount.focus();
return false;
}
}
</script>

</head>
<body>
<center><b>글삭제</b>
<br>
<form method="POST" name="delForm"  action="/Education/geunho/notice/deletePro.do?pageNum=${pageNum}"
   onsubmit="return deleteSave()">
<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
  <tr height="30">
     <td align=center>
       <b>비밀번호를 입력해 주세요.</b></td>
  </tr>
  <tr height="30">
     <td align=center >비밀번호 :  
       <input type="password" name="passwd" size="8" maxlength="12">
   <input type="hidden" name="n_num" value="${n_num}"></td>
</tr>
<tr height="30">
    <td align=center>
      <input type="submit" value="글삭제" >
      <input type="button" value="글목록"
       onclick="document.location.href='/Education/geunho/notice/Notice_list.do?pageNum=${pageNum}'">    
   </td>
</tr> 
</table>
</form>
</body>
</html>