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
 
    if(title == "" ||title == null) out.println("title이 null이다.");
    
    if(writer == "" ||writer == null) out.println("writer가 null이다.");     
     
    if(regdate == "" ||regdate == null)
        out.println("regdate가 null입니다.");
    else if(!Pattern.matches("/[0-9]{4}-[0-9]{2}-[0-9]{2}/", regdate))
        out.println("ex:2018-08-27 형식으로 사용하세요");
     
    if(content == "" ||content == null) out.println("content가 null입니다.");

%>

<html>
<head>

<title>게시판- 게시글 리스트</title>
</head>
<body>				<!-- HTML문서 주 내용이 삽입되는 부분 -->
<h1>게시글 리스트</h1> 	<!-- 헤드라인 글씨 표현을 하는 태그 -->
<table>				<!-- 표 형식 데이터 표현 태그 -->
	<tr>			<!-- table태그 내에 행을 정의할때 쓰는 태그 -->
	<th>번호</th>		<!-- table header table태그 내에서  -->
	<th>제목</th>		<!-- 강조하고 싶은 컬럼을 나타낼때 쓰는 태그 -->
	<th>조회수</th>
	<th>작성일자</th>
</tr>
<tr>
<td>1</td> <!-- 일반적인 테이블 데이터를 삽입할때 쓰는 태그 -->
<td>8월 공지사항</td>
<td>0</td>
<td>2018.8.27</td>

</table>
<a href="/Education/geunho/MVC1/write.jsp">글쓰기</a>
</body>
</html>