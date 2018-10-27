<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="./color.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body bgcolor="<%=bodyback_c%>">

	<form method="post" action="findPwdPro.jsp">
		<table>
			<tr bgcolor="<%=title_c%>">
				<td colspan="2">아이디와 주민1을 입력하세요</td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td>아이디 :</td><td> <input name="id"></td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td>주민1 :</td><td> <input name="jumin1"></td>
			</tr>
			<tr bgcolor="<%=value_c%>">
				<td colspan="2" align="right"><input type="submit" value="확인"></td>
			</tr>
			
		</table>
	</form>

</body>
</html>