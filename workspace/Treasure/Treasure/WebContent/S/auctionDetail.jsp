<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<SCRIPT language=JavaScript> 

function minbid() {
	
	if(${memId eq null} || ${memId eq ''}) {
		alert("로그인 후 입찰하여 주세요.");
		return false;                         
	}
	
	if(!document.bidform.bidp.value) {
		alert("입찰가를 입력하여 주세요.");
		document.bidform.bidp.focus();
		return false;
	}
	if(document.bidform.bidp.value <= ${bidderMap.bidp2}) {
		alert("3순위 입찰가보다 상위 입찰가를 입력하여 주세요.");
		document.bidform.bidp.focus();
		return false;
	}
	if(document.bidform.bidp.value <= ${bidderMap.mybidp}){
		alert("나의 입찰가보다 높은 금액으로 입찰하여 주세요.")
		return false;
	}
	
	return true;
}

function getTime() { 
now = new Date(); 
dday = new Date("${adb.auc_end}"); 
// 원하는 날짜, 시간 정확하게 초단위까지 기입.
days = (dday - now) / 1000 / 60 / 60 / 24; 
daysRound = Math.floor(days); 
hours = (dday - now) / 1000 / 60 / 60 - (24 * daysRound); 
hoursRound = Math.floor(hours); 
minutes = (dday - now) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound); 
minutesRound = Math.floor(minutes); 
seconds = (dday - now) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound); 
secondsRound = Math.round(seconds); 

document.getElementById("counter0").innerHTML = daysRound; 
document.getElementById("counter1").innerHTML = hoursRound; 
document.getElementById("counter2").innerHTML = minutesRound; 
document.getElementById("counter3").innerHTML = secondsRound; 
newtime = window.setTimeout("getTime();", 1000); 
} 

</SCRIPT>
<html>
<head>
<title>${adb.show_title}</title>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link href="show_style.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
</head>
<body>
<c:if test="${sessionScope.memId eq 'admin'}">
	<tiles:insertDefinition name="header_admin"/> 
</c:if>
<c:if test="${sessionScope.memId ne 'admin'}">
	<tiles:insertDefinition name="header"/> 
</c:if>
<tiles:insertDefinition name="menu_a" />

<div class = "right2">
<p>Category ▶  Auction ▶ ${adb.l_category_name} ▶ 진행 중 경매</p>
<div class="slideshow-container"> 
	<c:forTokens items="${adb.auc_image}" delims="," var="auc_image">
  	<div class="mySlides fade">
    <img src = "${pageContext.request.contextPath}${auc_image}" style=" width : 500px; height : 500px;" ></img>
	</div>
  </c:forTokens>
  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
  <c:forEach varStatus = "status" begin = "1" end = "${lengthimg}"> 
  <span class="dot" onclick="currentSlide(${status.current})"></span> 
  </c:forEach>
</div>
<script language="JavaScript" src="${pageContext.request.contextPath}/S/slide.js"></script>
		<div style="margin-left : 15px; width: 300px; height: 400px; display: inline; float: left;">
			<c:set var="bidderMap" value="${bidderMap}" />
			<h1 style="display: inline;">${adb.show_title}</h1>
			<DIV id=count style="display: inline;">
				<SPAN style="FONT: bold 12px Gulim; COLOR: #000" id=counter0></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">일</FONT><SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter1></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">시간</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter2></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">분</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter3></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">초 남음</FONT>
				</h6>
			</div>
			<br>
			<hr>
			<SCRIPT>getTime()</SCRIPT>
			<div>
				<h3>상위 입찰가</h3>
				<span>1순위 입찰가 ${bidderMap.bidp0}원</span><br> <span>2순위 입찰가 ${bidderMap.bidp1}원</span><br>
				<span>3순위 입찰가 ${bidderMap.bidp2}원</span>
			</div>
			<div>
				<h3>About the Auction</h3>
				<span>시작가</span><span style="float: right;">원</span><span
					style="float: right;">${adb.auc_sp}</span><br> <span>입찰
					단위</span><span style="float: right;">원</span><span style="float: right;">${adb.auc_unit}</span><br>
				<span>내 입찰가</span><span style="float: right;">원</span><span
					style="float: right;">${bidderMap.mybidp}</span><br> <span>경매
					참가자</span><span style="float: right;">명</span><span style="float: right;">${bidderMap.countbid}</span><br>
			</div>
			<br>
			<div style="width: 70%; display: inline">
			<div style = "display : inline; float : left;">
				<form name="bidform" method="post" action="/Treasure/S/auctionBid.do" style="display: inline;" onSubmit = "return minbid()">
							<div style = "width : 200px; margin-right : 0px; margin-top : 16px;"  >입찰금액 <input type="text" size="12" name="bidp"><input type="hidden" name = "user_id" value = "${adb.user_id}"><input type="hidden" name = "memId" value = "${memId}"><input type="hidden" name = "auc_ing_no" value = "${adb.auc_ing_no}">
							</div>
							<div style = "width : 200px; margin-right : 0px; margin-top : 5px;"><input type="submit" value="입찰하기" style="width: 200;" ></div>
				</form>
				</div>
				<form name = "interestform" method="post" action ="/Treasure/S/auctionInterest.do">
				<div style = "display : inline; float : left; margin-bottom : 1000px;">
					<button type = "submit" style = "background-color: white; border : 0px; margint-left : 10px;">
						<img src="${interesty}" id ="interestimg" name = "interestimg" width="50" height="50">
					</button>
					<input type="hidden" name = "interestyn" value = "y"><input type="hidden" name = "auc_ing_no" value = "${adb.auc_ing_no}"><input type="hidden" name = "user_id" value = "${adb.user_id}">
				</div>								
				</form>
			</div>
		</div>
		<div style = "width:800px; height:300px; display : block;">

<div style = "width:400px; height:30%; dispaly:inline; float:left; margin-top : 28px;">
<div style = "display : inline; float : left; width : 400px; height : 23px;"><h3 style = "display : inline; margin-top : 0px; margin-bottom : 18px; float : left;">${adb.show_title} &nbsp;</h3>
<img src = "../images/painteddia.png" style = "display : inline; float : left; margin-top : 10px;" width = "15" height = "15"></img>
<h6 style = "display : inline; float : left; margin-bottom : 10px; margin-top : 10px;">&nbsp;${countIlike}</h6></div>
<hr style = "margin-top : 10px; display : inline; float : left; width : 400px;">
<div style = "display : inline; float : left;">${adb.show_content}</div> 
</div>
<div style = "width:370px; height :30%; dispaly:inline; float:left; margin-left : 20px; margin-bottom : 5px;"><h3>About the Artist</h3>
<hr>
<div style = "display : inline; float : left;">
    <a href="/Treasure/J/otherfeed.do?user_id=${userId}"><img src = "${pageContext.request.contextPath}${adb.user_photo}" width = "50" height = "50"></img></a>

</div>
<div style = "display : inline;">
<a href="/Treasure/J/otherfeed.do?user_id=${userId}"><span style = "dispaly : inline; float : left; height : 10px;"><h5 style = "margin-top : 0px;">&nbsp;&nbsp;${userId}</h5></span> </a> <br><!-- <a href = "#"><span style = "dispaly : inline; float : right;"><h6 style = " margin-top : 0px;">쪽지보내기</h6></span></a><br> -->
<div style = "display : inline; float : left; width : 250px;"><h5 style = "margin-top : 0px; margin-left : 10px;">${adb.user_introduction}</h5></div><br>
</div>
</div>
</div>
</div>

</body>
</html>