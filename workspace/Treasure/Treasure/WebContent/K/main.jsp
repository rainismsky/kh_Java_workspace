<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function openLogin() {
	var popupX = (window.screen.width / 2) - (1200 / 2);
	// ���� �˾�â �¿� ũ���� 1/2 ��ŭ ���������� ���־���

	var popupY= (window.screen.height /2) - (700 / 2);
	// ���� �˾�â ���� ũ���� 1/2 ��ŭ ���������� ���־���

	window.open('/Treasure/K/loginForm.do', '�α���, ȸ������',
			'status=no, height=700, width=1200, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}

function openJoin() {
	var popupX = (window.screen.width / 2) - (1200 / 2);
	// ���� �˾�â �¿� ũ���� 1/2 ��ŭ ���������� ���־���

	var popupY= (window.screen.height /2) - (700 / 2);
	// ���� �˾�â ���� ũ���� 1/2 ��ŭ ���������� ���־���

	window.open('/Treasure/K/inputForm.do', '�α���, ȸ������',
			'status=no, height=700, width=1200, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
}
</script>
</head>
<body>
<c:if test="${empty sessionScope.memId}">
		
<a href="#" onclick="openLogin()">�α���</a>
<a href="#" onclick="openJoin()">ȸ������</a>
		
</c:if>

<c:if test="${!empty sessionScope.memId}">


<form method="post" action="/Treasure/K/logout.do">
<input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="�α׾ƿ�"></form>
<form name="myshow" action="/Treasure/K/modify.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-lg">ȸ����������</button></form>



</c:if>


</body>
</html>