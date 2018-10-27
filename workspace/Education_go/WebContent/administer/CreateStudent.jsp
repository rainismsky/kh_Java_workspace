<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>학생 추가</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script src="http://code.jquery.com/jquery-1.12.1.js"></script> 
 
<script> 
function check(formName){
    if(formName.s_name.value == ""){
       alert("학생 이름을 입력하세요");
       return false;
    }
    
    if(formName.t_id.value == ""){
       alert("선생님 아이디를 입력하세요");
       return false;
    }
    
    if(formName.u_id.value == ""){
       alert("학부모 아이디를 입력하세요");
       return false;
    }
    
    if(formName.s_birth.value == ""){
        alert("생년월일을 입력하세요");
        return false;
     }
    
    $.ajax({      
       type : "get",
       success : function(){
          alert("학생이 등록되었습니다!");
          opener.parent.location.reload();
          self.close();       
       }
    });
 }

</script> 
</head>

<body>
<div class="container">
  <h2>학생 추가하기</h2>
  <form name="create_student">
  
    <div class="form-group">
      <label for="s_name">이름:</label>
      <input type="text" class="form-control" name="s_name">
    </div>
    <div class="form-group">
      <label for="s_tel">연락처:</label>
      <input type="text" class="form-control" name="s_tel">
    </div>
    <div class="form-group">
      <label for="s_birth">생년월일: </label>
      <input type="text" class="form-control" name="s_birth" placeholder="yyyy/mm/dd"/>
    </div>
   
    <div class="from-group">
    	<label>이미지 : </label>
    	<input type="file" class="form-control" name="s_img" />
    </div>
    <div class="form-group">
    	<label>학부모ID : </label>
    	<input type="text" class="form-control" name="u_id" />
    </div>
    <div class="form-group">
    	<label>담당선생님ID : </label>
    	<input type="text" class="form-control" name="t_id" />
    </div>
    <button type="submit" class="btn btn-default" onclick="check(this.form)">계정 등록하기</button>
  </form>
</div>

</body>
</html>