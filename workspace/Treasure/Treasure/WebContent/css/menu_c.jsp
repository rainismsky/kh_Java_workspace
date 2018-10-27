<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/Treasure/css/menu.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

</head>
<body style="width: 243px;">
	<nav class="row"> <nav class="left">
	<h2>Creative Arts</h2>
	<hr width="100%" margin-left="10px">
	<div>
	<form action="/Treasure/J/hashtagAction.do">
	<input type="hidden" name="l_category_name" value="Creative Arts">
	<input type="text" id="hashtag" name="hashtag" placeholder="Search.." style="width:218px; height:45px;">
	</form>
	</div>
	<ul id="myMenu">
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=미술">미 술</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=도자공예">도자공예</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=가죽공예">가죽공예</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=금속공예">금속공예</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=목재공예">목재공예</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=유리공예">유리공예</a></li>
		<li><a href="/Treasure/E/list.do?l_category_name=Creative Arts&s_category_name=섬유공예">섬유공예</a></li>
	</ul>
	</nav> </nav>
</body>
</html>