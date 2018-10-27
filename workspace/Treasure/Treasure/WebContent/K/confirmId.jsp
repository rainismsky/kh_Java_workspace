<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>ID 중복확인</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<c:if test="${check == 1}">      
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <center><h3 class="display-5">"${user_id}" 는<br><br> 이미 사용중인 아이디입니다.</h3>
    <br><p class="lead">다른 아이디를 선택해주세요.</p></center>
  </div>
</div>

<form name="checkForm" method="post" action="/Treasure/K/confirmId.do">

       <center><input type="text" size="10" maxlength="12" name="user_id"> 
       <button type="submit" class="btn btn-outline-secondary btn-sm">ID 중복확인</button></center>
    
</form>
</c:if>
<c:if test="${check == -1}"> 
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <center><h3 class="display-5">"${user_id}" 는</h3>
    <br><p class="lead">사용 하실 수 있는 ID 입니다.</p></center>
  </div>
</div>
      <center><button type="button" class="btn btn-outline-secondary btn-sm" onclick="setid()">닫기</button></center>
   

</c:if>
</body>
</html>
<script language="javascript">

  function setid()
    {		
    	opener.document.userinput.user_id.value="${user_id}";
	self.close();
   }
  		opener.document.userinput.idcheck.value="${user_id}";
</script>