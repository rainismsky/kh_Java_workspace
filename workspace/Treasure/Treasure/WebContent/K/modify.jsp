<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<meta charset="utf-8">
<meta name="robots" content="noindex, nofollow">

<title>회원정보 수정</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
    /*    --------------------------------------------------
	:: Login Section
	-------------------------------------------------- */
#login {
    padding-top: 50px
}
#login .form-wrap {
    width: 30%;
    margin: 0 auto;
}
#login h1 {
    color: #0B3B17;
    font-size: 50px;
    text-align: center;
    font-weight: bold;
    padding-bottom: 20px;
}
#login .form-group {
    margin-bottom: 25px;
}
#login .checkbox {
    margin-bottom: 20px;
    position: relative;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    -o-user-select: none;
    user-select: none;
}
#login .checkbox.show:before {
    content: '\e013';
    color: #1fa67b;
    font-size: 17px;
    margin: 1px 0 0 3px;
    position: absolute;
    pointer-events: none;
    font-family: 'Glyphicons Halflings';
}
#login .checkbox .character-checkbox {
    width: 25px;
    height: 25px;
    cursor: pointer;
    border-radius: 3px;
    border: 1px solid #ccc;
    vertical-align: middle;
    display: inline-block;
}
#login .checkbox .label {
    color: #6d6d6d;
    font-size: 13px;
    font-weight: normal;
}
#login .btn.btn-custom {
    font-size: 14px;
	margin-bottom: 20px;
}
#login .forget {
    font-size: 13px;
	text-align: center;
	display: block;
}

/*    --------------------------------------------------
	:: Inputs & Buttons
	-------------------------------------------------- */
.form-control {
    color: #212121;
}
.btn-custom {
    color: #fff;
	background-color: #0B3B17;
}
.btn-custom:hover,
.btn-custom:focus {
    color: #fff;
}

</style>
</head>
<body>
<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h2>회원정보수정/탈퇴</h2><br>
                
                
                        <form name="myform" action="/Treasure/K/modifyForm.do" method="post">
                        <INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="회원정보수정">
                        
           			</form>
           			
           			<form name="myform" action="/Treasure/K/deleteForm.do" method="post">
                        <INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="회원탈퇴">
                        
           			</form>
           			<form name="myform" action="/Treasure/K/main.do" method="post">
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="메인으로">
                        
           			</form>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>

</body>
</html>