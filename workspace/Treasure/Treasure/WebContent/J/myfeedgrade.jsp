<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<meta charset="utf-8">
<meta name="robots" content="noindex, nofollow">

<title>로그인/회원가입</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<title>Insert title here</title>
</head>
<body>
<div class="row">
<br><br>
	<div class="col-xs-12 col-md-8 text-success"><h3><center>회원 등급</center><hr></h3></div>
</div>
<div class="row">
	<br><br>
	<div class="col-xs-12 col-md-8 text-muted"><CENTER><button type="button" class="btn btn-info btn-lg">Bronze</button>
	&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-secondary btn-lg">Silver</button>
	&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-warning btn-lg">Gold</button>
	&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-primary btn-lg">Dia</button></CENTER>
	
	</div>
</div>
<div style="position : absolute; margin-top : 10%; width:390;">
<div class="text-muted">        
        <center><h3>현재  "${gradeop.user_name}" 님은</h3><br>
     <h3>"${gradeop.user_grade}" 등급 회원 입니다.</h3></center></div>
        </div>



</body>
</html>
