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
<script language="javascript">
     
       function begin(){
         document.myform.user_id.focus();
       }
       function checkIt(){
         if(!document.myform.user_id.value){
           alert("이름을 입력하지 않으셨습니다.");
           document.myform.user_id.focus();
           return false;
         }
         if(!document.myform.user_pw.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.user_pw.focus();
           return false;
         }
         
         
        	
         
       }
    
   </script>
</head>


<BODY onload="begin()">
<form name="myform" action="/Treasure/K/loginPro.do" method="post" onSubmit="return checkIt()">
<section id="login">
    <div class="container">
    	<div class="row">
    	    <div class="col-xs-12">
        	    <div class="form-wrap">
                <h1>LOGIN</h1>
                
                    <form role="inform" action="/Treasure/K/loginPro.do" method="post" id="login-form" autocomplete="off">
                        <div class="form-group">
                            <label for="id" class="sr-only">ID</label>
                            <input type="text" name="user_id" id="id" class="form-control" placeholder="아이디">
                        </div>
                        <div class="form-group">
                            <label for="key" class="sr-only">Password</label>
                            <input type="password" name="user_pw" id="key" class="form-control" placeholder="비밀번호">
                        </div>
                        
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Log in">
                        
                        <input type="button" id="btn-login" class="btn btn-custom btn-lg btn-block" value="회원가입"
                        onclick="document.location.href='/Treasure/K/inputForm.do'">
                    </form>
                    <center>
                    <a href="/Treasure/K/IdSearchForm.do">아이디 찾기</a>&nbsp;&nbsp;
                    <a href="/Treasure/K/PasswdSearchForm.do">비밀번호 찾기</a>
                    </center>
                    <hr>
        	    </div>
    		</div> <!-- /.col-xs-12 -->
    	</div> <!-- /.row -->
    </div> <!-- /.container -->
</section>
</form>

</BODY>
</HTML>