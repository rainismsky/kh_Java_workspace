<%@ page import="pds.service.DeletePdsItemService"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<%
String[] strid = request.getParameterValues("delete");
 
int delcheck = DeletePdsItemService.getInstance().delete(strid);

%>

<c:set var="del" value="<%= delcheck %>"/>
<c:if test="${del == 0 }">
<script>
alert("삭제할 파일이 없습니다.");
history.go(-1);
</script>
</c:if>
<c:if test="${del != 0 }">
<c:redirect url="list.jsp"/>
</c:if>




</body>
</html>