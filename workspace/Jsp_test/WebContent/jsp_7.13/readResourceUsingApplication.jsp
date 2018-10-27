<%@page import="java.io.IOException"%>
<%@page import="com.sun.glass.ui.Application"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<html>
<head>

<title>application 기본 객체 사용해 자원 read!</title>
</head>
<body>

<% String resourcePath = "/chap06/message/notice/notice.txt";

%>
자원의 실제 경로: <br>
<%= application.getRealPath(resourcePath) %>
<br>
----------<br>
<%= resourcePath %> 의 내용  <br>
----------<br>

<%
	BufferedReader br = null;
char[] buff = new char[512];
int len = -1;

try{
	br = new BufferedReader(
			new InputStreamReader(
					application.getResourceAsStream(resourcePath)));
	while((len = br.read(buff)!= -1){
		out.print(new String(buff,0,len));
	}
}catch(IOException ex){
	out.println("익셉션 발생:"+ex.getMessage());
}finally{
	if(br != null) try {br.close(); } catch(IOException ex){}
}
%>


</body>
</html>