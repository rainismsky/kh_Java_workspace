<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check==1 }">
<meta http-equiv="Refresh" content="0;url=/Treasure/J/show_detail.do?show_no=${show_no}&&user_id=${user_id}">
<script>alert("신고가 완료되었습니다.");</script>
</c:if>
<c:if test="${check==0 }">
<meta http-equiv="Refresh" content="0;url=/Treasure/J/show_detail.do?show_no=${show_no}&&user_id=${user_id}">
<script>alert("이미 신고 하셨습니다.");</script>
</c:if>
<html>
<head>
<title>작품 신고하기</title>
</head>
<body>
</body>
</html>