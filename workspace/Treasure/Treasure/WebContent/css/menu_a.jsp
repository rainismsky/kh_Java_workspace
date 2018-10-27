<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="/Treasure/css/menu.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
        jQuery(".list-item").hide();
        $(".list").click(function()
        {
          $(".list-item").not($(this).next(".list-item").slideToggle(500)).slideUp();
        });
      });
</script>
</head>
<body>
	<nav class="row"> <nav class="left">
	<h2>Auction</h2>
	<hr width="100%" margin-left="10px">
	<input type="text" id="mySearch" placeholder="Search.."  style="visibility:hidden">
	<ul id="myMenu" style="margin-top: 10px;" >
		<li class="list" style="font-size: 20px; margin-top: 5px;">Creative Arts ▼</li>
		<div class="list-item">
		<li><a href="/Treasure/E/auctionList.do?l_category_name=Creative Arts">진행중인 경매</a></li>
		<li><a href="/Treasure/E/auction_endList.do?l_category_name=Creative Arts">마감된 경매</a></li>
		</div>
		<li class="list" style="font-size: 20px; margin-top: 5px;">Retro Collections ▼</li>
		<div class="list-item">
		<li><a href="/Treasure/E/auctionList.do?l_category_name=Retro Collections">진행중인 경매</a></li>
		<li><a href="/Treasure/E/auction_endList.do?l_category_name=Retro Collections">마감된 경매</a></li>
		</div>
	</ul>
	</nav> </nav>
</body>
</html>