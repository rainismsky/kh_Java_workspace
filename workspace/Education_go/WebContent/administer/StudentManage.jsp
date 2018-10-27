<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>

<script type="text/javascript">

function createStudent() {
   	url="./CreateStudent.do";
	
	window.open(url,"post","toolbar=no ,width=700 ,height=800,directories=no,status=yes,scrollbars=yes,menubar=no");
    }

 function deleteUser(formName) {
	 
	 url="./StudentManagePro.do?s_no="+formName.student_no.value;
     //alert(formName.student_no.value);
   	 alert("삭제되었습니다.");
   	 window.open(url, "post");	
   	 
 }
 
 function modifyUser(formName) {
	 url="./ModifyStudent.do?s_no="+formName.student_no.value;
     
   	 window.open(url, "post","toolbar=no ,width=700 ,height=800,directories=no,status=yes,scrollbars=yes,menubar=no");	
	 
 }
</script>


<style>
.content{
	position:absolute;
	left:17.5%;
	width:81.5%;
	height:86%;
	bottom:2%;
}

.btn-primary {
	float : right;
}
</style>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>보육의정석</title>
<% session.setAttribute("nav", 7); %>
</head>
<body>

<tiles:insertDefinition name="header"/>
<tiles:insertDefinition name="aside"/>
        
        <div class="content">
        	<br>
        	<div class="container">
  <h2>학생 관리</h2><!-- 부트스트랩 Hover Rows 참조! -->
  <p>학생들의 정보를 수정할 수 있습니다.</p><br><br>
   <button type="button" class="btn btn-primary" onclick="createStudent()">학생 추가</button>           
  <table class="table table-hover">
    <thead>
      <tr>
        <th></th>
        <th> 이  름</th>
        <th> 학부모</th>
        <th>  담당선생님</th>
        <th>  연락처</th>
        <th>  주  소</th>
        <th>  생년월일</th>
        <th> &nbsp;수  정</th>
        <th> &nbsp;&nbsp;삭  제</th>
      </tr>
    </thead>
    <tbody>

      <tr>
      
      <c:forEach var="s" items="${totalList}">
		<c:set var="no" value="${s.s_no}" /> 
		<c:set var="name" value="${s.s_name}" />
		<c:set var="birth" value="${s.s_birth}" />
		<c:set var="s_birth" value="${fn:substring(birth,0,10)}" />
		<c:set var="tel" value="${s.s_tel}" />
		<c:set var="t_id" value="${s.t_id}" />
		<c:set var="u_id" value="${s.u_id}" />
		<c:set var="u_grade" value="${s.u_grade}" />
		<c:set var="u_addr" value="${s.u_addr}" />
		<c:set var="t_name" value="${s.t_name}" />
		<c:set var="u_name" value="${s.u_name}" />
		
		<c:set var="number" value="0" />
					
		<form name="student" method="post" action="StudentManagePro.do">
		<%-- <c:forEach var="number01" begin="1" end="${no}" step="1"> --%>
		<tr>
		<td><%-- ${no} --%>
		<input type="hidden" name="student_no" value="${no}"></td>
		
        <td>${name}</td>
        <td>${u_name}</td>
        <td>${t_name}</td>
        <td>${tel }</td>
        <td>${u_addr}</td>
        <td>${s_birth}</td>
       	
        <td><input type="button" class="btn btn-info" value="수정" onclick="modifyUser(this.form)"/>
        <!-- onclick이 아니라 onSubmit="return checkIt()" 이거 인가...? -->
        
        </td>
        <td>
        <input type="hidden" name="update" value="no" />
        <input type="button" class="btn btn-danger" value="삭제" onclick="deleteUser(this.form)"/></td>
      
      </tr>
        </form>
	</c:forEach>
	</tr>
	
    </tbody>
  </table>

</div>
        	
        </div>
        
</body>
</html>