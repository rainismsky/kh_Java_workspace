<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="https://fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<meta charset="utf-8">
<meta name="robots" content="noindex, nofollow">

<title>회원정보 수정</title>
<html>
<script type="text/javascript">
<!--체크박스 제한-->
//설정 시작
var maxChecked = 3;
var totalChecked = 3;
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
        
        if(!userinput.user_pw.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.user_pw.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
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
       
        if(!userinput.user_name.value) {
            alert("사용자 이름을 입력하세요");
            return false;
        }
        if(!userinput.user_birth.value)
        {
            alert("생년월일을 입력하세요");
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
       
    }

    // 아이디 중복 여부를 판단
    function openConfirmid(userinput) {
        // 아이디를 입력했는지 검사
        if (userinput.user_id.value == "") {
            alert("아이디를 입력하세요");
            return;
        }
        // url과 사용자 입력 id를 조합합니다.
        url = "/Treasure/K/confirmId.do?user_id=" + userinput.user_id.value;
        
        // 새로운 윈도우를 엽니다.
        open(url, "confirm", 
        "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550, height=200");
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
    	    <h1><center>회원 정보수정 <small>Treasure</small></center></h1>
        </div>
        <form class="form-horizontal" method="post" action="/Treasure/K/modifyPro.do" enctype="Multipart/form-data"
        name="userinput" onSubmit="return checkIt()">
        

  <div class="form-group">
          <label class="col-sm-3 control-label" for="inputEmail">아이디</label>
        <div class="col-sm-6">
        <input class="form-control" type="text" name="user_id" maxlength="12" value="${member.user_id}" readonly/>
          
        </div>
        </div>
        
 <div class="form-group">
          <label class="col-sm-3 control-label" for="inputPassword">비밀번호</label>
        <div class="col-sm-6">
          <input class="form-control" type="password" name="user_pw" maxlength="12" value="${member.user_pw}">
        </div>
        </div>
          
          
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">이름</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_name" maxlength="10" value="${member.user_name}" readonly/>
          </div>
        </div>
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">생년월일</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_birth" maxlength="10" value="${member.user_birth}" readonly/>
          </div>
         </div>
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">성별</label>
          <div class="col-sm-6">
          
<c:if test="${member.user_gender=='남자'}">  
남<input type="radio" name="user_gender" value="남자" checked /></c:if>&nbsp;
<c:if test="${member.user_gender=='여자'}">
여<input type="radio" name="gender" value="여자" checked /></c:if>
          </div>
        </div>                
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">휴대전화</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_phone" maxlength="11" value="${member.user_phone}">
          </div>
        </div>        
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">이메일</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_email" maxlength="30" value="${member.user_email}">
          </div>
        </div>      
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">나의 가장 소중한 보물은?<br>(비밀번호 힌트)</label>
          <div class="col-sm-6">
            <input class="form-control" type="text" name="user_pw_hint" maxlength="50" value="${member.user_pw_hint}">
          </div>
        </div>   
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">작가소개</label>
          <div class="col-sm-6">
           <div id="container" style="width:500px">
 
 <div id="profile1" style="height:250px;width:300px;float:left;">
  <b>사진등록</b><br>
  
<input type="file" name="uploadFile" value="" accept="image/*" width="200" height="200" onchange="loadFile(event)">
<img id="output" src="../${member.user_photo}" width="200" height="200"/>
<input type="hidden" name="user_photo" value="${member.user_photo}" />
  
</div>
 <div id="profile2" style="height:120px;width:400px;float:left;"><b>간단한 자기 소개 등록</b><br>
 <textarea rows="3" cols="70" name="user_introduction" >${member.user_introduction}</textarea>
 </div>
 
</div>
          </div>
        </div>   
        
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName">내 관심사<br>(자동 추천 카테고리 3개 선택)</label>
          <div class="col-sm-6">
            <div id="menu" style="height:200px;width:150px;float:left;">
  <b>Creative Arts</b><br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="미술" <c:if test="${member.user_con1 eq '미술' || member.user_con2 eq '미술' || member.user_con3 eq '미술'}"> checked</c:if> />미술<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="도자공예" <c:if test="${member.user_con1 eq '도자공예' || member.user_con2 eq '도자공예' ||  member.user_con3 eq '도자공예'}"> checked</c:if> />도자공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="가죽공예" <c:if test="${member.user_con1 eq '가죽공예' || member.user_con2 eq '가죽공예' ||  member.user_con3 eq '가죽공예'}"> checked</c:if> />가죽공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="금속공예" <c:if test="${member.user_con1 eq '금속공예' || member.user_con2 eq '금속공예' ||  member.user_con3 eq '금속공예'}"> checked</c:if> />금속공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="목재공예" <c:if test="${member.user_con1 eq '목재공예' || member.user_con2 eq '목재공예' ||  member.user_con3 eq '목재공예'}"> checked</c:if> />목재공예<br>
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="유리공예" <c:if test="${member.user_con1 eq '유리공예' || member.user_con2 eq '유리공예' || member.user_con3 eq '유리공예'}"> checked</c:if> />유리공예<br> 
 <input type="checkbox" onclick=CountChecked(this) name="interest" value="섬유공예" <c:if test="${member.user_con1 eq '섬유공예' || member.user_con2 eq '섬유공예' || member.user_con3 eq '섬유공예'}"> checked</c:if> />섬유공예<br> 
 </div>
<div id="menu" style="height:200px;width:150px;float:left;">
  <b>Retro Collections</b><br>
  




																				
<input type="checkbox" onclick=CountChecked(this) name="interest" value="장식품" <c:if test="${member.user_con1 eq '장식품' || member.user_con2 eq '장식품' || member.user_con3 eq '장식품'}"> checked</c:if> />장식품<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="음악" <c:if test="${member.user_con1 eq '음악' || member.user_con2 eq '음악' || member.user_con3 eq '음악'}"> checked</c:if> />음악<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="영화" <c:if test="${member.user_con1 eq '영화' || member.user_con2 eq '영화' || member.user_con3 eq '영화'}"> checked</c:if> />영화<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="도서" <c:if test="${member.user_con1 eq '도서' || member.user_con2 eq '도서' || member.user_con3 eq '도서'}"> checked</c:if> />도서 <br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="게임" <c:if test="${member.user_con1 eq '게임' || member.user_con2 eq '게임' || member.user_con3 eq '게임'}"> checked</c:if> />게임<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="패션" <c:if test="${member.user_con1 eq '패션' || member.user_con2 eq '패션' || member.user_con3 eq '패션'}"> checked</c:if> />패션<br>
    
 </div>
 <div id="menu" style="height:200px;width:150px;float:left;">
  <br>
  
<input type="checkbox" onclick=CountChecked(this) name="interest" value="전자기기" <c:if test="${member.user_con1 eq '전자기기' || member.user_con2 eq '전자기기' || member.user_con3 eq '전자기기'}"> checked</c:if> />전자기기<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="화폐" <c:if test="${member.user_con1 eq '화폐' || member.user_con2 eq '화폐' || member.user_con3 eq '화폐'}"> checked</c:if> />화폐<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="우표" <c:if test="${member.user_con1 eq '우표' || member.user_con2 eq '우표' || member.user_con3 eq '우표'}"> checked</c:if> />우표<br>
<input type="checkbox" onclick=CountChecked(this) name="interest" value="피규어/프라모델" <c:if test="${member.user_con1 eq '피규어/프라모델' || member.user_con2 eq '피규어/프라모델' || member.user_con3 eq '피규어/프라모델'}"> checked</c:if> />피규어/프라모델<br>
    
 </div>
          </div>
        </div>     
     


        
 <div class="form-group">
            <label class="col-sm-3 control-label" for="inputName"></label>
          <div class="col-sm-6">
            <center><input type="submit" name="modify" value="수정" style = "display : inline; float : left; margin-left : 130px;" >
          </form>
          <form name="myshow" action="/Treasure/K/myfeed.do" method="post">
          <INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
          <button type="submit" style = "display : inline; float : left; margin-left : 10px;" onClick="document.location.href='/Treasure/K/modify.do'">취소</button></form>
          
          <form name="myshow" action="/Treasure/K/logondeleteForm.do" method="post">
          <INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
          <button type="submit" style = "display : inline; float : left; margin-left : 10px;" onClick="document.location.href='/Treasure/K/logondeleteForm.do'">회원탈퇴</button></form>
          
          </center></div>
</div>    
     


</body>
</html>