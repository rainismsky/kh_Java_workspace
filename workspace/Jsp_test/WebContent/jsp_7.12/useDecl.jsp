<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="day01.Calc" %>

<html>
<head><title>선언부를 사용한 두 정수값의 곱 </title></head>
<body>
<% Calc c = new Calc(); %>
10 * 25 = <%= c.multiply(10,25) %>

</body>
</html>