<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%-- <%@ page deferredSyntaxAllowedAsLiteral="true"%> --%>

<%@ page isELIgnored="true"%> 

<%-- 

<%@ page deferredSyntaxAllowedAsLiteral="true"%> : 
ex) #{test} 만 비활성화해주는것 , 특정한것만 비활성화 처리를함.

<%@ page isELIgnored="true" %> : 모든 EL을 무시 하는것

<%@ page isELIgnored="false" %> : 모든 EL을 적용 하는것

--%>

<%
	request.setAttribute("name","이름");
	session.setAttribute("name","이름");
	pageContext.setAttribute("name","page");
%>

#{test}

<html>
<head>
<title>EL Object</title>
</head>

<body>
${name} <br>
요청 URI : ${pageContext.request.requestURI}<br>
request의 name속성 : ${requestScope.name}<br>
code 파라미터 : ${param.code == null}

</body>
</html>
