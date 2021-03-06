<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>" %>
<%@ page import= "java.util.*"%>
<%@ page import= "java.net.*"%>
<%@ page import= "java.io.*"%>
<%@ include file="../view/color.jsp" %>

<%
String realPath = "";
String savePath = "fileSave";
String type = "utf-8";
int maxSize = 5*1024*1024;//5M

ServletContext context = getServletContext();
realPath = context.getRealPath(savePath);
ArrayList saveFiles = new ArrayList(); //서버에 저장된 파일명
ArrayList origFiles = new ArrayList(); //원본 파일명

String user = "";
String title = "";
String content = "";

try
{
	MultipartRequest multi = new MultipartRequest(request,realPath,maxSize,type,new DefaultFileRenamePolicy());
	
	user = multi.getParameter("txtUser");
	title = multi.getParameter("txtTitle");
	content = multi.getParameter("txtAbstract");
	Enumeration files = multi.getFileNames();
	while(files.hasMoreElements()){
		String name = (String) files.nextElement();
		saveFiles.add(multi.getFilesystemName(name));
		origFiles.add(multi.getOriginalFileName(name));
	}
	
%>

<html>
<head>
<title>여러개 파일을 업로드하는 예제</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="<%=bodyback_c%>">
<table width="50%" border="1" align="center" cellpadding="1" cellspacing="1">
<tr>
	<td width="15%" bgcolor="<%=value_c%>" align="center"><strong>작성자</strong></td>
	<td width="35%" colspan="3">
	<%=content%>
	</td>
</tr>
<tr><td colspan="4"><strong>업로드된 파일 리스트</strong></td>
</tr>

<%for(int i=0; i < saveFiles.size();i++){%>
<tr >
	<td colspan="4">
	<%
	String y=(String)saveFiles.get(i); //경로를 붙여 다운로드 받을 수 있게함
	String x=request.getContextPath()+"/"+savePath+"/"+URLEncoder.encode(y,"UTF-8"); // 프로젝트 패스(경로)/저장된 경로/한국어의 경우 인코딩 처리 utf-8지정 
	%>
	
	<%=i+1%>.<a href="<%=x%>" download><strong><%=origFiles.get(i)%></strong></a>
	
	</td>
</tr>
<%}%>
</table>
</body>
</html>
<%
}catch(IOException ioe){
	System.out.println(ioe);
}catch(Exception ex){
	System.out.println(ex);
}
%>