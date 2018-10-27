<%@ page import="el.Thermometer" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%
	Thermometer thermometer = new Thermometer();
	request.setAttribute("t",thermometer);
%>

<html>
<head>
<title> 온도 변환 예제 효댕아 사랑한다!</title>
</head>
<body>
${t.setCelsius('서울',1000)}
효댕이를 향한 마음의 온도 : 섭씨  ${t.getCelsius('서울')}도 / 화씨 ${t.getFahrenheit('서울')}

<br/>
정보: ${t.info}

</body>
</html>