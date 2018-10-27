<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import = "java.io.*" %>

<html>
<head>

<title>절대 경로 사용해 자원 read ㄱㄱ씽 ~!</title>
</head>

<body>
<%
	FileReader fi = null;
char[] buff = new char[512];
int len = -1;

try{
		fr = new FileReader("D:\\workspace\\Jsp_test\\WebContent\\message\\notice\\notice.txt");
		while((len - fr.read(buff)) != -1){
			out.print(new String(buff,0,len));
		}
		
}catch(IOException ex){
	out.pritnln("익셉션 발생:" + ex.getmessage);
	finally
	if(fr != null)try{fr.close();}catch(IOException ex){}
}
}

%>

</body>
</html>