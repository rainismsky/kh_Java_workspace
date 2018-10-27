<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="notice.inquiry_action.NoticeAction" %>

<html>
<head>
<title>글 내용</title>

<h1>보육의 정석</h1>

<script>
	function contentSave(formName){
		
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
<center><b>글내용 보기</b>
<br>

<table width="500" border="1" cellspacing="0" cellpadding="0" align="center"> 

  <tr height="30">
    <td align="center" width="125">글 제목
    <td align="center" width="375" align="center" colspan="3">${article22} ${arti}${article}
  </td>
  </tr>
  <tr>
    <td align="center" width="125">글 내용</td>
    <td align="left" width="375" colspan="3"><pre>${article}</pre></td> 
 </tr>

  <tr height="30">     
    <td colspan="5" align="right" >
   
  <input type="submit" value="답글 쓰기" onclick="contentSave(this.form)">
   &nbsp;&nbsp;&nbsp;&nbsp;
   


  <input type="button" value="목록 보기" onclick="window.location='/Education/geunho/notice/Notice_list.do'"> 
    &nbsp;&nbsp;&nbsp;&nbsp;
   
   <input type="text" value="${article}">
   <input type="text" value="${n_num}">
 <!--   &pageNum=${pageNum} -->       
    </td>
  </tr>   
</form>

<!-- </table>
<br>   
   <textarea name="content" id = "msg" cols="40" rows="10" onclick="this.value=''" ></textarea> <br>
   <input type="hidden" name="command" value="SendMessage">   
   <input type="submit" id="send" value="보내기" onclick  = "return send_msgList.jsp">   
   <input type="button" value="닫기" onclick="self.close()"/>
   <input type="reset" value="다시쓰기">
     <input type="button" value="목록보기" OnClick="window.location='send_msgList.jsp'">
</form> -->

</table>        
</body>
</html>