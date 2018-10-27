<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>보육의 정석 | 선생님 소개</title>

<style>

#out {
 width: 100%;
 text-align: center;
 }
#in {
 display: inline-block;
 }


.box2 {
  display: inline-block;
  width: 200px;
  height: 100px;
  margin: 1em;
}


.inline{ display: inline; width: 200px; height: 60px; }
.inline-block{ display: inline-block; width: 200px; height: 60px; *zoom: 1; }
	
</style>

<script>
  /* function view(formName){
	 
	 $.ajax({      
		 
		 //formName.update.value = "yes";
		 
	       type : "get",
	       success : function(){
	          alert("조회");
	          opener.parent.location.reload();
	          self.close();       
	       }
	    }); 
 } */


</script>

</head>
<body>	
	
<form name="Profile">

<select name="t_id">
	<option value="teacherid1">teacherid1</option>
	<option value="teacherid2">teacherid2</option>
	<option value="teacherid3">teacherid3</option>
</select>

<button type="submit" >조회</button>

</form> 
	
	<c:forEach var="profile" items="${list1}" >
	 <c:set var="name" value="${list1.t_name}" />
	 <c:set var="img" value="${list1.t_img}" />
	 <c:set var="tel" value="${list1.t_tel}" />
	 <c:set var="intro" value="${list1.t_intro}" />
	 <c:set var="career" value="${list1.t_career}" />
	
	<h1>${name}</h1><br />
	<h1>${tel}</h1><br />
	<h1>${career}</h1><br />
	<h1>${intro} </h1>
	</c:forEach>

</body>
</html>