<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.regex.Pattern"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
 
    int idx = 1;
 
    String title = request.getParameter("title");
 
    String writer = request.getParameter("writer");
 
    String regdate = request.getParameter("regdate");
 
    int count = 10000;
 
    String content = request.getParameter("content");
 
    if(title == "" ||title == null) out.println("title�� null�̴�.");
    
    if(writer == "" ||writer == null) out.println("writer�� null�̴�.");     
     
    if(regdate == "" ||regdate == null)
        out.println("regdate�� null�Դϴ�.");
    else if(!Pattern.matches("/[0-9]{4}-[0-9]{2}-[0-9]{2}/", regdate))
        out.println("ex:2018-08-27 �������� ����ϼ���");
     
    if(content == "" ||content == null) out.println("content�� null�Դϴ�.");

%>

<html>
<head>

<title>�Խ���- �Խñ� ����Ʈ</title>
</head>
<body>				<!-- HTML���� �� ������ ���ԵǴ� �κ� -->
<h1>�Խñ� ����Ʈ</h1> 	<!-- ������ �۾� ǥ���� �ϴ� �±� -->
<table>				<!-- ǥ ���� ������ ǥ�� �±� -->
	<tr>			<!-- table�±� ���� ���� �����Ҷ� ���� �±� -->
	<th>��ȣ</th>		<!-- table header table�±� ������  -->
	<th>����</th>		<!-- �����ϰ� ���� �÷��� ��Ÿ���� ���� �±� -->
	<th>��ȸ��</th>
	<th>�ۼ�����</th>
</tr>
<tr>
<td>1</td> <!-- �Ϲ����� ���̺� �����͸� �����Ҷ� ���� �±� -->
<td>8�� ��������</td>
<td>0</td>
<td>2018.8.27</td>

</table>
<a href="/Education/geunho/MVC1/write.jsp">�۾���</a>
</body>
</html>