<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<meta charset="utf-8">
<meta name="robots" content="noindex, nofollow">

<title>회원가입</title>
<script type="text/javascript">
<!--체크박스 제한-->
//설정 시작
var maxChecked = 3;
var totalChecked = 0;
//설정 끝
function CountChecked(field) {
if (field.checked)
totalChecked += 1;
else
totalChecked -= 1; 
if (totalChecked > maxChecked) {
alert ("최대 3개 까지만 가능합니다.");
field.checked = false;
totalChecked -= 1;
} 
}
function ResetCount(){
totalChecked = 0;
}

<!--이미지 업로드-->
var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };



<!--회원가입 유효성 검사-->

    function checkIt() {
        var userinput = eval("document.userinput");
        var regx = /^[a-zA-Z0-9]*$/;
        var regExp = /^[0-9]+$/;
        var regex= /[^0-9]/g
      	var regexx=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
        
        
        if(!userinput.user_id.value) {
            alert("ID를 입력하세요");
            return false;
        }
        
        if (!regx.test(userinput.user_id.value)){
        	  alert("아이디는 영어, 숫자만 입력가능합니다.");
        	  return false;
        	 }
        
        if(userinput.user_id.value.length<6){
        	  alert("아이디를 6글자 이상 입력해주세요");
        	  return false;
        	 }
        
        if(!userinput.user_pw.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        
        if (!regx.test(userinput.user_pw.value)){
      	  alert("비밀번호는 영어, 숫자만 입력가능합니다.");
      	  return false;
      	 }
      
      if(userinput.user_pw.value.length<6){
      	  alert("비밀번호를 6글자 이상 입력해주세요");
      	  return false;
      	 }
        if(userinput.user_pw.value != userinput.user_pw2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }
       
        if(!userinput.user_name.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        
        if(userinput.user_name.value.length<2){
        	  alert("이름을 성포함 최소 2글자 입력해주세요");
        	  return false;
        	 }
        
        if(!userinput.user_birth.value)
        {
            alert("생년월일을 입력하세요");
            return false;
        }
        
        if (!regExp.test(userinput.user_birth.value)){
      	  alert("숫자만 입력가능합니다.");
      	  return false;
      	 }
        
        if(userinput.user_birth.value.length<7){
      	  alert("양식에 맞게 써주세요");
      	  return false;
      	 }
        
        if(!userinput.user_phone.value)
        {
            alert("휴대전화를 입력하세요");
            return false;
        }
        
        if (!regExp.test(userinput.user_phone.value)){
        	  alert("숫자만 입력가능합니다.");
        	  return false;
        	 }
          
          if(userinput.user_phone.value.length<10){
        	  alert("양식에 맞게 써주세요");
        	  return false;
        	 }
          
        if(!userinput.user_email.value)
        {
            alert("이메일을 입력하세요");
            return false;
        }
        
        if (!regexx.test(userinput.user_email.value)){
        	  alert("양식에 맞게 써주세요.");
        	  return false;
        	 }
        
        if(!userinput.user_pw_hint.value)
        {
            alert("비밀번호 힌트를 입력하세요");
            return false;
        }
        if(userinput.user_pw_hint.value.length<2){
      	  alert("최소 2글자 이상 입력해주세요");
      	  return false;
      	 }
        
      if(totalChecked<3) 
      {
    	  alert("관심사는 3개까지 체크해야 합니다.");
    	  return false;
      }
      
      if(userinput.idcheck.value== ""){
      	alert("id중복 확인하세요");
      	return false;
      }
      if(userinput.idcheck.value != userinput.user_id.value){
      	alert("id중복 다시 확인하세요");
      	return false;
      } 
       
    }

    // 아이디 중복 여부를 판단
    function openConfirmid(userinput) {
        // 아이디를 입력했는지 검사
        if (userinput.user_id.value == "") {
            alert("아이디를 입력하세요");
            return;
        }
        var popupX = (window.screen.width / 2) - (500 / 2);
    	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

    	var popupY= (window.screen.height /2) - (300 / 2);
    	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
    	
        // url과 사용자 입력 id를 조합합니다.
        url = "/Treasure/K/confirmId.do?user_id=" + userinput.user_id.value;
        
        // 새로운 윈도우를 엽니다.
        open(url, '아이디 중복확인',
    			'status=no, height=300, width=500, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
    }
    
    function main() {
    window.opener.location.reload();    //부모창 reload


    window.close();    //현재 팝업창 Close
   
    }
    
</script>

        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
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

<article class="container">
        
        <div class="col-md-12">
        <div class="page-header">
    	    <h1><center>회원가입 <small>Treasure</small></center></h1>
        </div>
        <form class="form-horizontal" method="post" enctype="Multipart/form-data"
        action="/Treasure/K/inputPro.do" name="userinput" onSubmit="return checkIt()">
        <div class="form-group">
          <label class="col-sm-3 control-label" for="inputEmail">아이디</label>
        <div class="col-sm-6">
          <input class="form-control" name="user_id" maxlength="12" type="text" placeholder="아이디">
          <p class="help-block">
          <input type="button" name="confirm_id" value="아이디 중복확인" OnClick="openConfirmid(this.form)"></p>
          <input type="hidden" name="idcheck" value="">
          
        </div>
        </div>
        <div class="form-group">
          <label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
        <div class="col-sm-6">
          <input class="form-control" type="password" name="user_pw" maxlength="12" placeholder="비밀번호">
        </div>
        </div>
          <div class="form-group">
              <label class="col-sm-3 control-label" for="inputPasswordCheck">비밀번호 확인</label>
             <div class="col-sm-6">
              <input class="form-control" type="password" name="user_pw2" maxlength="12" placeholder="비밀번호 확인">
                <p class="help-block">비밀번호를 한번 더 입력해주세요.</p>
             </div>
          </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">이름</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_name" maxlength="10" placeholder="이름">
          </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">생년월일</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_birth" placeholder="ex:19910101" maxlength="8">
          </div>
        </div> 
		<div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">성별</label>
          <div class="col-sm-6">
            남<input type="radio" name="user_gender" value="남자" checked />&nbsp;여<input type="radio" name="user_gender" value="여자"/>
          </div>
        </div>       
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">휴대전화</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_phone" maxlength="11" placeholder="ex:01010041004">
          </div>
        </div> 
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">이메일</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_email" maxlength="30" placeholder="ex:Treasure@cherish.net">
          </div>
        </div> 
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">나의 가장 소중한 보물은?<br>(비밀번호 힌트)</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_pw_hint" maxlength="50">
          </div>
        </div>
		<div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">작가소개</label>
          <div class="col-sm-6">
           <div id="container" style="width:500px">
 
 <div id="profile1" style="height:250px;width:300px;float:left;">
  <b>사진등록</b><br>
  
  
  
  <input type="file" name="user_photo" accept="image/*" width="200" height="200" onchange="loadFile(event)">
<img id="output" width="200" height="200"/>

  
</div>
 <div id="profile2" style="height:120px;width:400px;float:left;"><b>간단한 자기 소개 등록</b><br>
 <textarea rows="3" cols="70" name="user_introduction"></textarea>
 </div>
 
</div>
          </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">내 관심사<br>(자동 추천 카테고리 3개 선택)</label>
          <div class="col-sm-6">
            <div id="menu" style="height:200px;width:150px;float:left;">
  <b>Creative Arts</b><br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="미술" />미술<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="도자공예" />도자공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="가죽공예" />가죽공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="금속공예" />금속공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="목재공예" />목재공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="유리공예" />유리공예<br> 
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="섬유공예" />섬유공예<br> 
 </div>
<div id="menu" style="height:200px;width:150px;float:left;">
  <b>Retro Collections</b><br>
  
<input type="checkbox" onclick=CountChecked(this) name="interest" value="장식품" />장식품<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="음악" />음악<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="영화" />영화<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="도서" />도서 <br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="게임" />게임<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="패션" />패션<br>
    
 </div>
 
 <div id="menu" style="height:200px;width:150px;float:left;">
  <br>
  
<input type="checkbox" onclick=CountChecked(this) name="interest" value="전자기기" />전자기기<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="화폐" />화폐<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="우표" />우표<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="피규어/프라모델" />피규어/프라모델<br>
    
 </div>
          </div>
        </div> 
        <hr>
       <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName"></label>
          <div id="menu" style="height:200px;width:120px;float:left;">
 </div>
          <div class="col-sm-6">
          
          <button type="submit" class="btn btn-Secondary">회원가입</button>
          <button type="reset" class="btn btn-Secondary">다시입력</button>
          <button type="button" class="btn btn-Secondary" onclick="main();">메인으로</button>
          
            
        </div>
        </form>
         
        </div>
      </article>
  </body>
</html>
