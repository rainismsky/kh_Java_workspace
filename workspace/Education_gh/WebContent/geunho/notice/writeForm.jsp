<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script>
	function writeSave(formName){
		
		if(formName.n_subject.value==""){
		  alert("제목을 입력하십시요.");
		  formName.n_subject.focus();
		  return false;
		}
		if(formName.n_content.value==""){
		  alert("내용을 입력하십시요.");
		  formName.n_content.focus();
		  return false;
		}
		formName.submit();
	}   
</script>
</head>

<body> 
<center><b>글쓰기</b>
<br>
<form method="post" name="writeform" action="/Education/geunho/notice/writePro.do">

<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">

  <tr>
    <td  width="90" align="center" >글 제목</td>
    <td  width="350">
   	<input type="text" size="40" maxlength="50" name="n_subject" ></td>
  </tr>
  <tr>
    <td  width="90" align="center" >글 내용</td>
    <td  width="350" >
     <textarea name="n_content" rows="13" cols="40"></textarea> </td>
  </tr>
     <tr>
    <td  width="70" align="center" >p.w</td>
    <td  width="330" >
     <input type="password" size="8" maxlength="12" name="passwd">
</td>
  </tr>
    
<tr>     
<td colspan=2 align="center">
  <input type="button" value="글쓰기" onclick="writeSave(this.form)"> 
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/Education/geunho/notice/Notice_list.do'">
</td>
</tr>
</table>   
</form>     
</body>

<!-- 
   </table>
   ★내용  <br>   
   <textarea name="content" id = "msg" cols="40" rows="10" onclick="this.value=''" >ㅋ</textarea> <br>
   <input type="hidden" name="command" value="SendMessage">   
   <input type="submit" id="send" value="보내기" onclick  = "return notice.jsp">   
   <input type="button" value="닫기" onclick="self.close()"/>
   <input type="reset" value="다시쓰기">
     <input type="button" value="목록보기" OnClick="window.location='notice.jsp'">
</form> -->

</html>      