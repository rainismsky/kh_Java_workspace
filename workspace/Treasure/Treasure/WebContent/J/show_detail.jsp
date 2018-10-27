<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="show_style.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Concert+One" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Concert+One|Libre+Baskerville:700" rel="stylesheet">
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>작품</title>
<script type="text/javascript" src="script.js"></script>
<script type="text/javascript">
function loginck() {
	
	if(${sessionId eq null} || ${sessionId eq ''}) {
		alert("로그인 후 이용해 주세요~");
		return false;                         
	}
	
	return true;
}

$(function() {
    $('#content').keyup(function (e){
        var content = $(this).val();
        $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
        $('#counter').html(content.length + '/100자');
    });
    $('#content').keyup();
});
</script>
</head>
<body>
<div class="page">
<c:if test="${sessionScope.memId eq 'admin'}">
	<tiles:insertDefinition name="header_admin"/> 
</c:if>
<c:if test="${sessionScope.memId ne 'admin'}">
	<tiles:insertDefinition name="header"/> 
</c:if>
<c:if test="${l_category_name eq 'Creative Arts'}">
	<tiles:insertDefinition name="menu_c" />
</c:if>
	<c:if test="${l_category_name eq 'Retro Collections'}">
<tiles:insertDefinition name="menu_r" />
</c:if>
<div class="right2">
<h5>Category ▶ ${sdb.l_category_name } ▶ ${sdb.s_category_name }</h5>
<c:if test="${sessionScope.memId eq 'admin'}">
		<button style="right: 780px; top: 50px; position: absolute;">삭제하기</button>
</c:if>
<c:if test="${sessionScope.memId eq sdb.user_id}">
		<button style="right: 780px; top: 50px; position: absolute;">삭제하기</button>
</c:if>
<div class="show">
<div class="slideshow-container">

	<c:forTokens items="${sdb.show_image }" delims="," var="show_image">
  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <img src="${pageContext.request.contextPath}${show_image}" style="width:100%">
  </div>
	</c:forTokens>
	
  <!-- <div class="mySlides fade">
    <img src="../images/happytears2.png" style="width:100%">
  </div>

  <div class="mySlides fade">
    <img src="../images/happytears3.jpg" style="width:100%">
  </div>
  
  <div class="mySlides fade">
    <img src="../images/happytears4.jpg" style="width:100%">
  </div> -->

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
  <c:forEach varStatus = "status" begin = "1" end = "${lengthImg}"> 
  <span class="dot" onclick="currentSlide(${status.current})"></span> 
  <!-- <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
  <span class="dot" onclick="currentSlide(4)"></span>  -->
  </c:forEach>
  <br>
</div>
<br>
<script language="JavaScript" src="slide.js"></script>
<div class="show-info">
	<div class="show-title">
	<h2>${sdb.show_title }</h2>
	</div>
	<div class="show-like" align="right">
	<img src="../images/painteddia.png" style="width:25px">
	<font class="like"> ${totalLike } </font>
	</div>
	<br>
	<hr style="width: 300px">
	
	<div class="show-content">
	${sdb.show_content }
	</div>
	
	<div class="artist">
	<a href="/Treasure/J/otherfeed.do?user_id=${sdb.user_id}"><img class="photo" src="${pageContext.request.contextPath}${sdb.user_photo}" style="width:40px"></a>
	<font class="artist-about">About the ${sdb.user_id }</font>
	<br>
	<div class="artist-intro">${sdb.user_introduction } </div>
	</div>
	
	<div class="buttons">
		<div class="likeb">
		<form name="likeform" method="post" action="/Treasure/J/likeAction.do">
		<input type="hidden" name = "show_no" value = "${sdb.show_no}">
		<input type="hidden" name = "artist" value = "${sdb.user_id}">
		<button type="submit" class="imgbuttonL" onclick="return loginck()">
		<img src="${likedia }" style="width:90px"><br></button>
		<div class="button-font">좋아요</div>
		</form>
		</div>
		<div class="bookb">
		<form name="bookmarkform" method="post" action="/Treasure/J/bookmarkAction.do">
		<input type="hidden" name = "show_no" value = "${sdb.show_no}">
		<input type="hidden" name = "user_id" value = "${sdb.user_id}">
		<button type="submit" class="imgbuttonB" onclick="return loginck()">
		<img src="${bookmarkbox }" style="width:90px"><br></button>
		<div class="button-font">담아두기</div>
		</form>
		</div>
		<div class="reportb">
		<form name="showreportform" method="post" action="/Treasure/J/showreportAction.do">
		<input type="hidden" name = "show_no" value = "${sdb.show_no}">
		<input type="hidden" name = "user_id" value = "${sdb.user_id}">
		<button type="submit" class="imgbuttonR" onclick="return loginck()">
		<img src="../images/sirenw.png" style="width:90px"><br></button>
		<div class="button-font">신고하기</div>
		</form>
		</div>
	</div>
</div>
</div>
<div style=”clear:both;”></div>
<div class="hashtag">
	<c:forEach var="htag" items="${hashtagList }">
	<a href="/Treasure/J/hashtagAction.do?hashtag=${htag.h_tag}&l_category_name=${sdb.l_category_name}" class="myButton">#${htag.h_tag }</a>
	</c:forEach>
	<!-- <a href="#" class="myButton">#행복한눈물</a>
	<a href="#" class="myButton">#Hanna</a>
	<a href="#" class="myButton">#눈물</a>
	<a href="#" class="myButton">#미술</a>
	<a href="#" class="myButton">#아트</a>
	<a href="#" class="myButton">#행복</a>
	<a href="#" class="myButton">#창작품</a>
	<a href="#" class="myButton">#미술</a>
	<a href="#" class="myButton">#대학생</a> -->
</div>
<div style=”clear:both;”></div>
<div class="comment">
<hr>
<div class="comment-font"> Comment</div>
<hr>
<form method="post" name="commentform" action="/Treasure/J/lcommentPro.do" onsubmit="return writeSave()" onclick="return loginck()">
<input type="hidden" name = "show_no" value = "${sdb.show_no}">
<input type="hidden" name = "user_id" value = "${sdb.user_id}">
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="5" rowspan="2">
		<textarea id="content" name="content" rows="5" cols="90" maxlength="99" style="width: 700px"></textarea>
		</td>
		<td>
		<input type="submit" value="답글달기"><br>
		</td>
	</tr>
	<tr>
		<td align="right">
		<span id="counter"></span>
		</td>
	</tr>
</table>
</form>

<c:forEach var="lcomm" items="${lcommentList }">
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center" height="80" style="background-color: #EAEAEA; margin-bottom: 10px;">
	<tr>
		<td width="100" align="center" style="font-weight: bold;">
		<img class="photo" src="${pageContext.request.contextPath}${lcomm.comm_user_photo}" style="width:40px"><br>
		${lcomm.comm_user_id }
		</td>
		<td width="500">
		${lcomm.l_comm_content }
		</td>
		<td width="200" align="right">
		<fmt:formatDate value="${lcomm.l_comm_date}" pattern="yyyy-MM-dd, HH:mm:ss"/> &nbsp;
		</td>
	</tr>
</table>
</c:forEach>
</div>
</div>
</div>
</body>
</html>