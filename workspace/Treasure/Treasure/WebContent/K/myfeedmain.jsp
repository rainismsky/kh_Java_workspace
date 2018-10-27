<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<title></title>
<script type="text/javascript">
function openGrade() {
	var popupX = (window.screen.width / 2) - (380 / 2);
	// 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height /2) - (450 / 2);
	// 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음

	window.open('/Treasure/K/MyfeedGradePro.do?user_id=${sessionScope.memId}', '로그인, 회원가입',
			'status=no, height=450, width=400, left='+ popupX + ', top='+ popupY + ', screenX='+ popupX + ', screenY= '+ popupY);
	return false;
}
</script>
<style type="text/css">
::-webkit-scrollbar {

display:none;

}
</style>
</head>
<body>
<tiles:insertDefinition name="header" />
<tiles:insertDefinition name="menu_m" />

<div class="right2" style="width: 1000px; display: inline; float: left; position: absolute; ">


         <div class="row" style="left:300px; width: 900px; -ms-overflow-style: none;">
         <br><br>
         <div class="col-md-12 text-muted"><h2>${member.user_name} 님의 피드</h2><hr></div>
		
		  
		  <div style="height:300px;width:400px;float:left;"><br>
		 
		  <img src="${pageContext.request.contextPath}${member.user_photo}" alt="..." class="img-responsive img-circle" style="width:320px; height:320px;">
		</div>
		
		<div style="height:300px;width:180px;float:right;">
          <br>
          <br><table width=300 cellpadding="0" cellspacing="0" align="right">
		<tr>
			<td width="300" height="50">
	<form name="myshow" action="/Treasure/K/MyfollowerForm.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-lg">팔로워</button></form>
			</td>
			<td width="300" height="50">
	<form name="myshow" action="/Treasure/K/MyfollowingForm.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-lg">팔로잉</button></form>
			</td>
			<td width="300" height="50">
	<form name="myshow" action="/Treasure/K/myfeed.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-lg">작품수</button></form>
			</td>			
           			
		</tr>
		<tr>
			<td width="300" height="50"><center><c:forEach var="item2" items="${fowcount}">${item2.follower}</c:forEach></center></td>
			<td width="300" height="50"><center><c:forEach var="item3" items="${fowicount}">${item3.following}</c:forEach></center></td>
			<td width="300" height="50"><center><c:forEach var="item1" items="${count}">${item1.show_no}</c:forEach></center></td>
		</tr>
		<tr>
			<td width="300" height="50"><h3>회원등급 :</h3></td>
			<td width="200" height="50"><form name="myshow" action="/Treasure/K/MyfeedGradePro.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}"><a href="#" onclick="return openGrade()"></form><h3>${member.user_grade}</h3></a></td>
			
		</tr>
		</table>
		<div style="height:300px;width:220px;float:right;">
		<table>
		<tr>
			<td width="800" height="50">
	<form name="myform" action="/Treasure/K/modifyForm.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-secondary btn-lg" onclick="openModify()" style = "width : 200px;">회원정보수정</button></form>

			</td>
		</tr>
		</table></div>
		<br>
		
        </div>
        
         <div style="position : absolute; margin-top : 50%; width:800;">
        <hr>
        <table><tr><td><h3>나의 소개</h3></td></tr><tr><td>${member.user_introduction}<td></td></table>
        </div>
        
        <div style="position : absolute; margin-top : 70%; width:800;">
        <hr>
        <table><tr><td><center><h3>작품 리스트</h3></center></td></tr></table>
        </div>
        
        <div style="position : absolute; margin-top : 83%; width:800;">
        
       
        <c:forEach var="item" items="${articleList}">
			<div class="col-md-3">
				<a href="/Treasure/J/show_detail.do?show_no=${item.show_no}&&user_id=${sessionScope.memId}"><img src="${pageContext.request.contextPath}${item.show_image}" style="width:180px; height:180px;" class="img-responsive" /></a>
				<br/>
				<center><h4>${item.show_title}</h4></center>
			</div>
			</c:forEach>
        
        
</div>

</div>

</body>
</html>