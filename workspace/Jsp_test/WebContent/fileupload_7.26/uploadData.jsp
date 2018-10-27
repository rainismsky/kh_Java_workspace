<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.io.*" %>

<html>
<head>

<title>Insert title here</title>
</head>
<body>

<%
InputStream is = null;
out.print("[");
out.print(request.getContentType());
out.println("]");
try{
	is=request.getInputStream();
	int data = -1;
	while((data=is.read())!=-1){
		out.print((char)data);
	}
}finally{
	if(is != null)try{is.close();}catch(IOException ex){}
}
%>

</body>
</html>