<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width-device-width", initial-scale="1"> 

<!-- 부트스트랩은 컴퓨터,폰에서도 볼수 있도록 디자인이 알아서 변동되는 탬플릿 구조 이기에 간단하게 쓰기 위해 메타 태그를 집어넣어줌 -->

<link rel="stylesheet" href="/Education/geunho/css/bootstrap.css">

<title>보.석 login</title>
</head>
<body>
<%
 String userID = null;
if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");
}
%>

<!-- 보.석 게시판 메인 페이지  -->

<nav class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
		data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
		aria-expanded="false">
		<span class="icon-bar"></span> <!--줄였을때 나오는 메뉴바 작대기를 표시한다 ㅋ-->
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="main.jsp">보.석 게시판 웹 사이트</a>
		</div>
	<div class="callapse navbar-callapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="/Education/geunho/logon/main.jsp">메인</a></li> <!--li태그는 원소 역할을 한다-->
			<li><a href="/Education/geunho/logon/bbs.jsp">게시판</a></li>
		</ul> <!-- ul은 하나의 어떤 리스트를 보여줄때 쓰는것 -->
		<%
		if(userID == null){
		%>
		
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">회원 관리<span class="caret"></span></a> <!-- <span class="caret"></span> : 하나의 icon 같은 것 -->
	<ul class="dropdown-menu">
		<li><a href="/Education/geunho/logon/logoutAction.jsp">Logout</a></li> <!-- <li class="active"> 액티브라는것은 현재 선택이 되었다는 뜻  단 한개의 홈페이지에만 들어갈 수 있으며 현재의 페이지를 의미하는 것 -->
		
	</ul>
	</li>
	</ul>
	
	<% 
		}
	%>
	</div>
</nav> <!-- nav는 하나의 웹사이트의 전반적인 구성을 보여주는 역할을 함 -->
<div class="contoiner">
	<div class="row">
	<form method="post action="writeAction.jsp">
	<table class="table table-striped" style="text-align; center; border: 1px solid $dddddd">
	<thead>
	<tr> <!-- 한 행을 의미 -->
	<th colspan="2" style="background-color: #eeeeee; text-align; center;">게시판 글쓰기 양식</th>
	</tr>
	</thead>
	<tbody>
		<tr>
		<td>1</td>
		<td>홍일동</td>
		<td>2017-05-04</td>
		<td><input type="text" calss="form-control" placeholder="글 제목" name="bbsTitle" maxlength="50"></td>
		<td><textarea type="text" calss="form-control" placeholder="글 내용" name="bbsContent" maxlength="3000" style="height:350px;"></textarea></td>
		
	</tbody>
	</table>
	<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
	</form>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/Education/geunho/js/bootstrap.js"></script>

</body>
</html>