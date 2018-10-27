<%@ page language="java" contentType="text/html; charset=utf-8"%>
<% 
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="memberInfo" class="usebean.MemberInfo"/>
<jsp:setProperty="memberInfo" property="*"/>
<jsp:setProperty="memberInfo" property="password" value=""/>

<html>
<head>
<title>가입</title>
</head>
<body>

<table width="400 border="1" cellpadding="0" cellspacing="0"></table>
<tr>
	<td>ID</td>
	<td><jsp:getProperty name="memberInfo" property="id"/></td>
	<td>암호</td>
	<td><jsp:getProperty name="memberInfo" property="id"/></td>
</tr>
<tr>
<tr>
<td>이름</td>
    <td><jsp:getProperty name="memberInfo" property="name" /></td>
    <td>이메일</td>
    <td><jsp:getProperty name="memberInfo" property="email" /></td>
</tr>

</table>

</body>
</html>