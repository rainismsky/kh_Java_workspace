<%@ page language="java" contentType="text/html; charset=utf-8"%>

<html>
<head>

<title>파일 업로드 예제</title>
</head>
<body>

<form name="fileForm" method="past" enctype="myltipart/form-data" action="fileUpload.jsp">
작성자:
<input type="text" name="user"><br>
제목:
<input type="text" name="title"><br>
파일명:
<input type="file" name="uploadFile"><br>
<input type="submit" value="파일 올리기"><br>

</form>
</body>
</html>