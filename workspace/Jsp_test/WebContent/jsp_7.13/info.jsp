<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>

<title>INFO!!!!!!!!!!!</title>
</head>

<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
<td>제품번호</td>
<td>xxxxx</td>
</tr>

<tr>
<td>price</td>

<td>10,000원</td>
</tr>
</table>

<%-- <jsp:include page="infoSub.jsp" flush="false">
<jsp:param name="type" value="B'/></jsp:include> --%>

<%request.setAttribute("type", "A"); %>
<jsp:include page="infoSub.jsp" flush="false"/>

</body>
</html>