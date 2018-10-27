<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ include file="color.jsp" %>

<%
String comment_num=request.getParameter("cmn");
	String content_num=request.getParameter("ctn");
	String p_num=request.getParameter("p_num");
	String url="content1.jsp?num="+content_num+"&pageNum="+p_num; //글삭제가 됬을때도 다시 content1.jsp 다시 들고갈수있도록 쿼리를 작성해놨다
	String pageNum = request.getParameter("pageNum");
%>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">

<script language="javaScript">

	function deleteSave(){
		if(document.delForm.passwd.value=="){
			alert("pw를 입력하라!");
			document.delForm.passwd.focus();
			return false;
		}
	}
</script>	
</head>

<body bgcolor=<%=bodyback_c %>>
<center>
<form method=post name=delForm action="delCommentPro.jsp" onsubmit="return deleteSave()">
<table border=1 align=center cellspacing=0 cellpadding=0 width=360>
<tr height=30>
<td align=center bgcolor=<%=value_c %>>
<b>pw입력!</b>
</td>
</tr>
<tr height=30>
<td align=center>
pw: <input type="password" name=passwd size=8 maxlength=12>
<input type=hidden name=content_num value=<%=content_num%>>
<input type=hidden name=comment_num value=<%=comment_num%>>
<input type=hidden name=pageNum value=<%=pageNum %>>
</td>
</tr>
<tr height=30>
<td align=center bgcolor=<%=value_c %>>
<input type="submit" value="COMENT 삭제">
<input type="botton" value="취소" onclick="document.location.href='<%=url%>'">
</td>
</tr>
</form>
</table>
</center>
</body>
</html>