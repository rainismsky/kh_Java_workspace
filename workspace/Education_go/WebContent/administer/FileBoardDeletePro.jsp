<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="color.jspf"%>
<html>
<head>
<style>
.content{
	position:absolute;
	border:red 2px solid;
	left:17.5%;
	width:81.5%;
	height:86%;
	bottom:2%;
}

.content pre{
	background-color: white;
	border: none;
} 

#container table{
	font-style: normal;
	font-size:medium;
	font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
}

</style>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="style.css" rel="stylesheet" type="text/css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>보육의정석</title>
<% session.setAttribute("nav", 5); %>
</head>
<body>

<tiles:insertDefinition name="header"/>
<tiles:insertDefinition name="aside"/>
        
	<div class="content">
 		<br>
	    <div class="container">
			 <h2>자료게시판</h2><!-- 부트스트랩 Hover Rows 참조! -->
			 <p>자료를 업로드 및 다운로드할 수 있습니다.</p><br>  
			 
			 <div id="fileBoard" align="center">
				<h3>글 삭제</h3>
			 </div>
			 
			 <c:if test="${check==1}">
			<body bgcolor="${bodyback_c}">
			<br>
			<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
				<tr height="30">
					<td align=center  bgcolor="${value_c}">
						삭제 성공
					</td>
				</tr>
					
				<tr height="30">
						<td align=center >삭제했습니다.</td>
				</tr>
				<tr height="30">
					<td align=center bgcolor="${value_c}">
<!-- 						<a href="document.location.href='/Education/administer/FileBoard.do'">[목록으로 돌아가기]</a> -->
						<button class="btn btn-success" onclick="javascript:window.location='/Education/administer/FileBoard.do'">목록보기</button>  
					</td>
				</tr> 
			</table>
			</body>
			</c:if>
			
			<c:if test="${check==0}">
			<body bgcolor="${bodyback_c}">
			<br>
			<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
				<tr height="30">
					<td align=center  bgcolor="${value_c}">
						삭제 실패
					</td>
				</tr>
					
				<tr height="30">
						<td align=center >비밀번호가 다릅니다.</td>
				</tr>
				<tr height="30">
					<td align=center bgcolor="${value_c}">
						<!-- <a href="javascript:history.go(-1)">[글삭제 폼으로 돌아가기]</a> -->
						<button class="btn btn-success" onclick="javascript:history.go(-1)">글삭제 폼으로 돌아가기</button>  
					</td>
				</tr> 
			</table>
			</body>
			</c:if>
		</div>
	</div>  
</body>
</html>