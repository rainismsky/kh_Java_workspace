<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script>
	function writeSave(formName){
		
		if(formName.i_subject.value==""){
		  alert("제목을 입력하십시요.");
		  formName.i_subject.focus();
		  return false;
		}
		if(formName.i_content.value==""){
		  alert("내용을 입력하십시요.");
		  formName.i_content.focus();
		  return false;
		}
		formName.submit();
	}   
</script>


</head>

<body> 
<center><b>글쓰기</b>
<br>
<form method="post" name="writeform" action="/Education/geunho/inquiry/i_writePro.do">

<table width="400" border="1" cellspacing="0" cellpadding="0"  align="center">

  <tr>
    <td  width="90" align="center" >글 제 목</td>
    <td  width="350">
   	<input type="text" size="40" maxlength="50" name="i_subject" ></td>
  </tr>
  <tr>
    <td  width="90" align="center" >글 내 용</td>
    <td  width="350" >
     <textarea name="i_content" rows="13" cols="40"></textarea> </td>
  </tr>
    
<tr>     
<td colspan=2 align="center">
  <input type="button" value="글쓰기" onclick="writeSave(this.form)"> 
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/Education/geunho/inquiry/inquiry_list.do'">
</td></tr></table>   
</form>     
</body>

<!-- 
   </table>
   ★내용  <br>   
   <textarea name="content" id = "msg" cols="40" rows="10" onclick="this.value=''" >쪽지 내용을 입력해 주세요. 불건전한 내용(음란, 광고)은 신고 대상이 될 수 있습니다.</textarea> <br>
   <input type="hidden" name="command" value="SendMessage">   
   <input type="submit" id="send" value="보내기" onclick  = "return notice.jsp">   
   <input type="button" value="닫기" onclick="self.close()"/>
   <input type="reset" value="다시쓰기">
     <input type="button" value="목록보기" OnClick="window.location='notice.jsp'">
</form> -->

</html>      