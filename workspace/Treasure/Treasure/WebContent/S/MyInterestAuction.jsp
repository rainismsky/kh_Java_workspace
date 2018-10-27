<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<SCRIPT> 

/* function getTime(auc_end) { 
	now = new Date(); 
	dday = new Date(auc_end); 
	// 원하는 날짜, 시간 정확하게 초단위까지 기입.
	days = (dday - now) / 1000 / 60 / 60 / 24; 
	daysRound = Math.floor(days); 
	hours = (dday - now) / 1000 / 60 / 60 - (24 * daysRound); 
	hoursRound = Math.floor(hours); 
	minutes = (dday - now) / 1000 /60 - (24 * 60 * daysRound) - (60 * hoursRound); 
	minutesRound = Math.floor(minutes); 
	seconds = (dday - now) / 1000 - (24 * 60 * 60 * daysRound) - (60 * 60 * hoursRound) - (60 * minutesRound); 
	secondsRound = Math.round(seconds); 
  	var dday2 = daysRound + "일" + hoursRound + "시" + minutesRound + "분" + secondsRound + "초 남음" +;
	document.getElementById("counter0").innerHTML = dday2; 
	document.getElementById("counter1").innerHTML = hoursRound; 
	document.getElementById("counter2").innerHTML = minutesRound; 
	document.getElementById("counter3").innerHTML = secondsRound;
	newtime = window.setTimeout("getTime("${adb.auc_end}");", 1000);
	alert(dday2);
	}  */

</SCRIPT>
<html>
<head>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
<title>나의 경매 현황</title>
<link href="${pageContext.request.contextPath}/css/head.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='../css/box.css' type='text/css' />
</head>
<body>
	<tiles:insertDefinition name="header" />
	<tiles:insertDefinition name="menu_m" />
	<div class="right2"
		style="display: inline; float: left; position: absolute; margin-left: 0px; left: 35%; top: 190px;">
		<div style="left: 25%; position: absolute;">
			<a href="/Treasure/S/myAuction.do?tab=경매가능"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">경매 가능</button></a>
			<a href="/Treasure/S/myAuction.do?tab=판매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">판매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=구매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">구매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=관심경매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: #0B3B17; color : white;">관심 경매</button></a>
		</div>
		<div style = "margin-top : 55px; width : 900px;">
		<h2>경매 진행 중</h2>
		<hr align="left" width ="700px">
		</div>
		<c:if test = "${interestAucSize eq 0}">
		<div style = "width : 700px; position : abolute; border : 1px solid; text-align : center; top : 200px;" >
		경매 진행 중인 관심경매 작품이 없습니다.
		</div>
		</c:if>
		<c:forEach var="interestAucList" items="${interestAucList}">
		<div>
		<div style = "width : 380px; display : inline; float : left; margin-top : 10px;" >
		<img src = "${pageContext.request.contextPath}${interestAucList.auc_image}" style = "width : 350px; height : 300px;">
		</div>
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		
		<a href="/Treasure/S/auctionDetail.do?auc_ing_no=${interestAucList.auc_ing_no}&&user_id=${interestAucList.user_id}"><h2 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >제목${interestAucList.show_title}</h2></a><DIV id=count style="display: inline; float : right;">
				<h6><SPAN style="FONT: bold 12px Gulim; COLOR: #000" id=counter0></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px"></FONT><SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter1></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px"></FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter2></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px"></FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter3></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px"><fmt:formatDate value="${interestAucList.auc_end}" pattern="yyyy-MM-dd, HH:mm"/>마감</FONT></h6>
				
			</div>
		</div>
		<!-- <SCRIPT>getTime("${interestAucList.auc_end}")</SCRIPT> -->
		<br>
		<div style = "display : inline; float : left; width : 300px; margin-top : 15px;">▶최고 입찰가<span style ="float : right;">원</span> <span style = "float : right">${interestAucList.i_bidding_p}</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶시작가<span style ="float : right;">원</span> <span style = "float : right">${interestAucList.auc_sp}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶입찰 단위<span style ="float : right;">원</span> <span  style = "float : right">${interestAucList.auc_unit}</span>
		</div>	
		</div>
		</div>
		<hr width = "700px" style = "margin-top : 15px; display : inline; float :left;">
		</c:forEach>
</div>

</body>
</html>