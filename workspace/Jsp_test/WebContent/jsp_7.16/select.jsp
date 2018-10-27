<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>

<title> 옵션 선택 화면 </title>
</head>

<body>

<form action="<% request.getContextPath() %>/chap07/view.jsp">

보려는 페이지 select! :

<select name="code">

<option value="A"> A 페이지 </option>
<option value="B"> B 페이지 </option>
<option value="C"> C 페이지 </option>

</select>

<input type="submit" value="이동">
</form>

</body>
</html>