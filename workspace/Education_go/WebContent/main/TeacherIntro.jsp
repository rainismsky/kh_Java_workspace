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
  function view(formName){
	 
	 $.ajax({      
		 
		 //formName.update.value = "yes";
		 
	       type : "get",
	       success : function(){
	          alert("조회");
	          opener.parent.location.reload();
	          self.close();       
	       }
	    }); 
 }


</script>

</head>
<body>	
	
	<div>
	<jsp:include page="header.jsp" />
	</div>
	
	<div id="out">
	<div id="in">
	<h3>보석의 선생님을 소개합니다!</h3>
	<form name="teacherIntro">
	 <select>	 
	 	<c:forEach var="teacherName" items="${name}" >
	 	<c:set var="tname" value="${t_name}"/>	
	 		<option>${teacherName.tname}</option>
	 </c:forEach>	
	 </select>
	 	<button type="submit" onclick="view(this.form)"  value="조회" ></button>
	</form>
	
	
	<%-- <c:forEach var="teacher" items="${providerList}" varStatus="status">

		<option value="${prt.id}" ${prt.id == provider ? 'selected="selected"' : '' }>${prt.nm}</option>

	</c:forEach> --%>

	
	<br /><br /><br /><br /><br />                   	
	<div id="box-container">
		<span class="inline">
			<%-- <img style="width: 100px; height: 100px;" src="${t_img}" /> --%>
			<img src="${pageContext.request.contextPath}${fn:substring(img,85,120)}" alt="M_img" style="width: 300px; height: 300px;" />
			<%-- ${pageContext.request.contextPath}${fn:substring(img,85,120)} --%>
		</span>
		<span class="inline-block">
		
		<!-- **** -->
		<c:forEach var="list" items="${list1 }">
		<c:set var="img" value="${list.main_img }" />
		<%-- ${fn:substring(img,85,100)} --%>
			<div class="item" id="in">
       <img src="${pageContext.request.contextPath}${fn:substring(img,85,120)}" alt="M_img" style="width: 1000px; height: 700px;">
      		</div>
		</c:forEach>
		<!-- **** -->
		
			<table border="1">
     <tr>
     	<td>${pageContext.request.contextPath}${fn:substring(img,85,120)}</td>
     </tr>
     <tr>
     	<td>${t_career}</td>
     </tr>
     <tr>
     	<td>${t_intro}</td>
     </tr>
     <tr>
     	<td>${t_img}</td>
     </tr>
     <tr>
     	<td>${t_name}</td>
     </tr> 
     <tr>
     	<td>${t_tel}</td>
     </tr>
     <tr>
     	<td><button type="submit" onclick="" value="상담신청하기"/></td>
     </tr>
	</table> 
		</span>
	</div>
	
</div>
</div>

	<%-- <div>
	<jsp:include page="footer.jsp" />
	</div> --%>
	
</body>
</html>