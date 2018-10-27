<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%java.util.Date d = new java.util.Date();
java.text.SimpleDateFormat sdf = 
new java.text.SimpleDateFormat("yyyy년 MM월 dd일 hh시  mm분 ss초");%>

현재시간 :: <%=sdf.format(d) %>


</body>
</html>