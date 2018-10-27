<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>선생님 프로필 추가</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script src="http://code.jquery.com/jquery-1.12.1.js"></script>
<script>
function modifyProfile(formName){
    
    $.ajax({      
       type : "get",
       success : function(){
    	  alert(formName.t_id.value);
          alert("선생님 페이지가 생성되었습니다!");
          opener.parent.location.reload();
          self.close();       
       }
    });
 }
</script>
</head>
<body>
<div class="container">
  <h2>선생님 프로필</h2>
  
  <form name="t_profile">
    <div class="form-group">
      <label>선생님 ID: *</label>
      <input type="text" class="form-control" name="t_id" value="${t_id}" readonly />
    </div>
    <div class="form-group">
    	<label>이미지</label>
    	<input type="file" class="form-control" name="t_img" value="${t_img}"/>
    </div>
    <div class="form-group">
    	<label>보육경력</label>
    	<input type="text" class="form-control" name="t_career" value="${t_career}"/>
    </div>
    <div class="form-group">
    	<label>소개말</label>
    	<input type="text" class="form-control" name="t_intro" value="${t_intro}"/>
    	<input type="hidden" name="update" id="eunju" value="no" />
    </div>
    <button type="submit" class="btn btn-default" onclick="modifyProfile(this.form)">수정하기</button>
  </form>
</div>
</body>
</html>