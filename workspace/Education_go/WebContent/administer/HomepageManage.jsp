<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<script language="JavaScript" src="/Education/administer/js.js"></script>
<style>
.content{
   position:absolute;
   border:red 2px solid;
   left:17.5%;
   width:81.5%;
   height:86%;
   bottom:2%;
}

.btn-info{
	float:right;
}

.btn-primary{
	float:right;
	margin:10px;
}

</style>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>보육의정석</title>
<% session.setAttribute("nav", 1); %>
</head>
<body>

<tiles:insertDefinition name="header"/>
<tiles:insertDefinition name="aside"/>
        
<div class="content">
	<br>
    <div class="container">
		 <h2>홈페이지 관리</h2><!-- 부트스트랩 Hover Rows 참조! -->
		 <p>기본 홈페이지 페이지를 수정할 수 있습니다.</p><br><br>            

	<fieldset>
		<legend>메인 페이지 수정</legend>
		
		<form>
		<table width="80%" align="center">	
			<tr>
				<td rowspan="${filecounter1+1}">&nbsp;&nbsp;&nbsp;업로드할 이미지 개수 입력 :&nbsp;
				<input type="text" name="addcnt1">&nbsp;<input type="button" value=" 확인 " class="btn btn-success" onclick="addFile1(this.form)"></td>
				<td></td>
			</tr>
		</form>
		<form name="frmName2" method="post" enctype="multipart/form-data">
				<c:forEach var="i" begin="1" end="${filecounter1}">
					<tr><td><input type="File"  name="selectFile${i}" ><br></td></tr>
				</c:forEach>
				<input type="hidden"  name="type" value="main_img">
		</table>
					<input type="Button" value="변경" class="btn btn-info" onclick="elementCheck1(this.form)">
		</form>
	</fieldset><br>
	
	<fieldset>
		<legend>보석 소개 페이지 수정</legend>
		
		<form>
		<table width="80%" align="center">	
			<tr>
				<td rowspan="${filecounter2+1}">&nbsp;&nbsp;&nbsp;업로드할 이미지 개수 입력 :&nbsp;
				<input type="text" name="addcnt2">&nbsp;<input type="button" value=" 확인 " class="btn btn-success" onclick="addFile2(this.form)"></td>
				<td></td>
			</tr>
		</form>
		<form name="frmName2" method="post" enctype="multipart/form-data">
				<c:forEach var="i" begin="1" end="${filecounter2}">
					<tr><td><input type="File"  name="selectFile${i}" ><br></td></tr>
				</c:forEach>
				<input type="hidden"  name="type" value="introduce_img">
		</table>
					<input type="Button" value="변경" class="btn btn-info" onclick="elementCheck2(this.form)">
		</form>
	</fieldset><br>
	
	<fieldset>
		<legend>서비스 안내 페이지 수정</legend>
		
		<form>
		<table width="80%" align="center">	
			<tr>
				<td rowspan="${filecounter3+1}">&nbsp;&nbsp;&nbsp;업로드할 이미지 개수 입력 :&nbsp;
				<input type="text" name="addcnt3">&nbsp;<input type="button" value=" 확인 " class="btn btn-success" onclick="addFile3(this.form)"></td>
				<td></td>
			</tr>
		</form>
		<form name="frmName2" method="post" enctype="multipart/form-data">
				<c:forEach var="i" begin="1" end="${filecounter3}">
					<tr><td><input type="File"  name="selectFile${i}" ><br></td></tr>
				</c:forEach>
				<input type="hidden"  name="type" value="service_img">
		</table>
					<input type="Button" value="변경" class="btn btn-info" onclick="elementCheck3(this.form)">
		</form>
	</fieldset><br>
		<br>
		<button class="btn btn-primary" onclick="document.location.href='/Education/administer/BosukSosik.do'">&nbsp;보석소식으로 이동&nbsp;</button>
		<button class="btn btn-primary" onclick="document.location.href='/Education/administer/Inquiry.do'">&nbsp;문의사항으로 이동&nbsp;</button>
	</div>
</div>
        
</body>
</html>