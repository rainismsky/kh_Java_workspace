<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>


<style>

.btn-primary {
	float : right;
}

.content {
	position: absolute;
	left: 17.5%;
	width: 81.5%;
	height: 86%;
	bottom: 2%;
}
</style>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>보육의정석</title>
<%
	session.setAttribute("nav", 2);
%>

<script language="JavaScript">
function createProfile() {
   	url="CreateTeacherProfile.do?";
	
	window.open(url,"post","toolbar=no ,width=700 ,height=800,directories=no,status=yes,scrollbars=yes,menubar=no");
    }
    
function modifyProfile(formName) {
	//alert(formName.teacher_id.value)
   url="ModifyTeacherProfile.do?t_id="+formName.teacher_id.value;
    	
   window.open(url,"post","toolbar=no ,width=700 ,height=800,directories=no,status=yes,scrollbars=yes,menubar=no");
	
    }
   
function deletePro(formName) {
	//alert(formName.teacher_id.value);
	url="./TeacherProfileManagePro.do?t_id="+formName.teacher_id.value;
	alert("삭제되었습니다.");
	window.open(url,"post");
}
    
</script>
</head>
<body>

	<tiles:insertDefinition name="header" />
	<tiles:insertDefinition name="aside" />

	<div class="content">
		<br>
		<div class="container">
			<h2>선생님 페이지 관리</h2>
			<p>선생님 프로필 화면을 관리합니다. </p><br><br>
			<button type="button" class="btn btn-primary" onclick="createProfile()">선생님 프로필 추가</button>
			<!-- 부트스트랩 Hover Rows 참조! -->
			<table class="table table-hover">
				<thead>
					<tr>
						<th>이 름</th>
						<th>보육경력</th>
						<th>연락처</th>
						<th>이미지</th>
						<th>소개말</th>
						<th>수 정</th>
						<th>&nbsp;&nbsp;삭 제</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="pro" items="${profile}">
						<c:set var="t_id" value="${pro.t_id}" />
						<c:set var="name" value="${pro.t_name}" />
						<c:set var="career" value="${pro.t_career}" />
						<c:set var="tel" value="${pro.t_tel}" /> 
						<c:set var="img" value="${pro.t_img}" />
						<c:set var="intro" value="${pro.t_intro}" />

						<tr>
				<form name="profile">
					<td>${name}</td>
					<td>${career}</td>
					<td>${tel}</td>
					<td>${img}</td>
					<td>${intro}</td>
					<%-- <td>${t_id}</td> --%>
					<td>
						<input type="button" class="btn btn-info" onclick="modifyProfile(this.form)" value="수정" />
					</td>
					<td>
						<input type="hidden" name="teacher_id" value="${t_id}" />
						<input type="button" class="btn btn-danger" value="삭제" onclick="deletePro(this.form)" />
					</td>
					</tr>
				</form>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

</body>
</html>