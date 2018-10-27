<%@ page contentType="text/html; charset=UTF-8" %>
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
<tiles:insertDefinition name="header"/>
<tiles:insertDefinition name="menu_c" />
<div class="right2">
<h5>Category▶Creative Arts▶미 술</h5>
<div class="show">
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade">
    <div class="numbertext">1 / 4</div>
    <img src="../images/happytears.jpg" style="width:100%">
  </div>

  <div class="mySlides fade">
    <div class="numbertext">2 / 4</div>
    <img src="../images/happytears2.png" style="width:100%">
  </div>

  <div class="mySlides fade">
    <div class="numbertext">3 / 4</div>
    <img src="../images/happytears3.jpg" style="width:100%">
  </div>
  
  <div class="mySlides fade">
    <div class="numbertext">4 / 4</div>
    <img src="../images/happytears4.jpg" style="width:100%">
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
  <span class="dot" onclick="currentSlide(4)"></span> 
  <br>
</div>
<br>
<script language="JavaScript" src="slide.js"></script>
<div class="show-info">
	<div class="show-title">
	<h2>행복한 눈물</h2>
	</div>
	<div class="show-like" align="right">
	<img src="../images/painteddia.png" style="width:25px">
	<font class="like"> 3,100 </font>
	</div>
	<br>
	<hr style="width: 300px">
	
	<div class="show-content">
	명언이나 격언, 잠언은 어떤 교훈이나 가르침을 주는 말 또는 학문 등의 핵심을 간략하게 외우고 말하기 쉽게 그 내용을 간결하고 짧은 문장으로 표현한 것을 가리킨다.
	</div>
	
	<div class="artist">
	<img src="../images/user.png" style="width:40px">
	<font class="artist-about">About the UserId</font>
	<br>
	<div class="artist-intro">명언이나 격언, 잠언은 어떤 교훈이나 가르침을 주는 말 또는 학문 </div>
	</div>
	
	<div class="buttons">
		<div class="likeb">
		<img src="../images/dia.png" style="width:90px"><br>
		<div class="button-font">좋아요</div>
		</div>
		<div class="bookb">
		<img src="../images/diabox.png" style="width:90px"><br>
		<div class="button-font">담아두기</div>
		</div>
		<div class="sirenb">
		<img src="../images/sirenw.png" style="width:90px"><br>
		<div class="button-font">신고하기</div>
		</div>
	</div>
</div>
</div>
<div style=”clear:both;”></div>
<div class="hashtag">
	<a href="#" class="myButton">#행복한눈물</a>
	<a href="#" class="myButton">#Hanna</a>
	<a href="#" class="myButton">#눈물</a>
	<a href="#" class="myButton">#미술</a>
	<a href="#" class="myButton">#아트</a>
	<a href="#" class="myButton">#행복</a>
	<a href="#" class="myButton">#창작품</a>
	<a href="#" class="myButton">#미술</a>
	<a href="#" class="myButton">#대학생</a>
</div>
<div style=”clear:both;”></div>
<div class="comment">
<hr>
<div class="comment-font"> Comment</div>
<hr>
<form method="post" name="commentform" action="/Treasure/J/writeCommentPro.do" onsubmit="return writeSave()">
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td colspan="5" rowspan="2">
		<textarea id="content" rows="5" cols="90" maxlength="99" style="width: 700px"></textarea>
		</td>
		<td>
		<input type="submit" value="답글달기"><br>
		</td>
	</tr>
	<tr>
		<td>
		<span id="counter"></span>
		</td>
	</tr>
</table>
</form>
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center" height="80" style="background-color: #EAEAEA; margin-bottom: 10px;">
	<tr>
		<td width="100" align="center" style="font-weight: bold;">
		<img src="../images/user.png" style="width:40px"><br>
		hj0521
		</td>
		<td width="500">
		정말 멋잇는 작품이에요~!!
		</td>
		<td width="200" align="right">
		2018-08-21, 10:07PM &nbsp;
		</td>
	</tr>
</table>
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center" height="80" style="background-color: #EAEAEA; margin-bottom: 10px;">
	<tr>
		<td width="100" align="center" style="font-weight: bold;">
		<img src="../images/user.png" style="width:40px"><br>
		sunming
		</td>
		<td width="500">
		정말 멋잇는 작품이에요~!!!!
		</td>
		<td width="200" align="right">
		2018-08-21, 10:07PM &nbsp;
		</td>
	</tr>
</table>
</div>
</div>
</div>
</body>
</html>