<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"
			data-toggle="dropdown" role="button" aria-haspopup="true"
			aria-expanded="false">접속<span class="caret"></span></a> <!-- <span class="caret"></span> : 하나의 icon 같은 것 -->
	<ul class="dropdown-menu">
		<li class="active"><a href="/Education/geunho/logon/login.jsp">Login</a></li> <!-- <li class="active"> 액티브라는것은 현재 선택이 되었다는 뜻  단 한개의 홈페이지에만 들어갈 수 있으며 현재의 페이지를 의미하는 것 -->
		<li><a href="/Education/geunho/logon/join.jsp">Sign Up</a></li>
	</ul>
	</li>
	</ul>
	</div>
</nav> 
<!-- nav는 하나의 웹사이트의 전반적인 구성을 보여주는 역할을 함 -->
<!-- 보.석 게시판 로그인 양식 -->
<div class="container"> <!-- <div class="container"> 컨테이너를 넣어 하나의 컨테이너 처럼 감싸줌  -->
	<div class="col-lg-4"></div>
	<div class="jumbotron" style="padding-top20px;">	<!-- 현재 중간라인엔 로그인 양식이 들어감  -->
		<form method="post"	action="Education/geunho/logon/loginAction.jsp"><!-- 이 안에는 하나의 form 양식이 들어간다. post는 회원가입,로그인 등..의 어떠한 정보를 숨기면서  보낼떄 쓰는 메소드 라고 할 수 있음. -->
			<h3 style="text-align: center;">login page</h3>
		<div class="form-group">
			<input type="text" class="form-control" placeholder="ID" name="userID" maxlength="20"> 
			</div>
			<!--<input type="text">어떠한 정보를 삽입 할 수 있는 input 삽입  
			 	placeholder="ID" : 현재 어떠한 것도 입력되지 않았을 때 보여지는것,
			 	주의사항 매개변수를 입력하는 것으로서 ex) name="userID","userPassword" <= 대소문자 구분 확실히 할 것
				name: 서버 프로그램을 작성 할 때 사용하기에 굉장히 중요한 요소
				maxlength="20" : 내용을 넣었을때 글자가 너무 길어지지 않게 막아주는 것 
			-->
			<div class="form-group">
				<input type="password" class="form-control" placeholder="pw" name="userPassword" maxlength="20"> 
			</div>			
		<input type="submit" class="btn btn-primary form-control" value="Signup">
	<div class="col-lg-4"></div>
</div>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="/Education/geunho/js/bootstrap.js"></script>

</body>
</html>