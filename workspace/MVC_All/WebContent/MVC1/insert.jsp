<%@ page import=" java.util.regex.Pattern" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<%
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	String regdate=request.getParameter("regdate");
	String content=request.getParameter("content");
	
	if(title == "" ||title == null)out.println("title�� null�̴�.");
	
	if(writer == "" ||writer == null)out.println("writer�� null�̴�.");
	
	if(regdate == "" ||regdate == null)out.println("regdate�� null�Դϴ�.");
	else if(!Pattern.matches("/[0-9]{4}-[0-9]{2}-[0-9]{2}/",regdate))out.println("���� ���� x.");
	
	if(title == "" ||title == null)out.println("title�� null��.");
	
	try{
		String driverName = "oracle.jdbc.driver.Oracledriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		Class.forName(driverName);
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		out.println("Oracle DB�� ���� ����!");
		con.close();
	}catch(Exception e){
		out.println("Oracle DB ���ӿ� ����!.<hr>");
		out.println(e.getMessage());
		e.printStackTrace();
		
	}
	

%>
<body>

</body>
</html>