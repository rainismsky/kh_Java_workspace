<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head><title>파일 등록</title></head>
<body>
<form action="upload.jsp" method="post" enctype="multipart/form-data"> <!-- "multipart/form-data" 이걸로 전송해야 파일 내용이 전송됨 -->
파일: <input type="file" name="file" /> <br/>
설명: <input type="text" name="description" /> <br/>
<input type="submit" value="업로드" />
</form>
</body>
</html>