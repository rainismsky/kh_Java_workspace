<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>

<title>서버 정보 출력</title>
</head>
<body>

<!-- 특정 웹 애플리케이션에 포함된 모든 JSP페이지는 하나의 application 객체를 공유함.
웹 어플리케이션 전반에 걸쳐서 사용되는 정보를 담고 있다.
초기 설정정보 , 서버 정보 , 웹 어플리케이션이 제공하는 자원.
-->

서버 정보 : <%= application.getServerInfo() %> <br>
서블릭 규약 메이저 .ver : <%= application.getMajorVersion() %>
서블릭 규약 마이너 .ver : <%= application.getMinorVersion() %>

</body>
</html>