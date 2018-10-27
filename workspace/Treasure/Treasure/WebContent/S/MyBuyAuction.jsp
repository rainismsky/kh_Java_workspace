<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<SCRIPT> 

function writeReview() {
    var url = "/Treasure/S/writeReviewForm.do?auc_end_no=" + review.auc_end_no.value + "&&e_bidder=" + review.e_bidder.value + "&&auc_title=" + review.auc_title.value;    
    window.open(url, "writeReview", "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=300");
    return false;	
}


function getTime() { 
	var time2 = document.getElementById("timer").value;
	now = new Date(); 
	dday = new Date(time2); 
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
	} function getTime() { 
		var time2 = document.getElementById("timer").value;
		now = new Date(); 
		dday = new Date(time2); 
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
<title>나의 경매 현황</title>
<link href="${pageContext.request.contextPath}/css/head.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='../css/box.css' type='text/css' />
	<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
	<tiles:insertDefinition name="header" />
	<tiles:insertDefinition name="menu_m" />
	<div class="right2"
		style="display: inline; float: left; position: absolute; margin-left: 0px; left: 35%; top: 190px;">
		<div style="left: 25%; position: absolute;">
			<a href="/Treasure/S/myAuction.do?tab=경매가능"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">경매 가능</button></a>
			<a href="/Treasure/S/myAuction.do?tab=판매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">판매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=구매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: #0B3B17; color : white;">구매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=관심경매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">관심 경매</button></a>
		</div>
		<div style = "margin-top : 55px; width : 900px;">
		<h2>경매 진행 중</h2>
		<hr align="left" width ="700px">
		</div>
		<div>
		<c:if test = "${buyingSize eq 0}">
		<div style = "width : 700px; position : abolute; border : 1px solid; text-align : center; top : 200px;" >
		경매 진행 중인 구매 작품이 없습니다.
		</div>
		</c:if>
		 <c:if test = "${buyingSize > 0}"> 
		 <c:forEach var = "buyingList" items = "${buyingList}" begin = "${bingPageNum-1}" end = "${bingPageNum-1}"> 
		<div style = "width : 380px; display : inline; float : left;" >
		<img src = "${pageContext.request.contextPath}${buyingList.auc_image}" style = "width : 350px; height : 300px;">
		</div>
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		
		<a href="/Treasure/S/auctionDetail.do?auc_ing_no=${buyingList.auc_ing_no}&&user_id=${buyingList.user_id}"><h2 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >${buyingList.show_title}</h2></a><DIV id=count style="display: inline; float : right;">
				<h6><SPAN style="FONT: bold 12px Gulim; COLOR: #000" id=counter0></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">일</FONT><SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter1></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">시간</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter2></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">분</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter3></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">초 남음</FONT></h6>
				
			</div>
		</div><form name = "time"><input type = "hidden" id = "timer" name = "timer" value = "${buyingList.auc_end}"></form>
		<SCRIPT>getTime()</SCRIPT>
		<br>
		<div style = "display : inline; float : left; width : 300px; margin-top : 15px;">▶최고 입찰가<span style ="float : right;">원</span> <span style = "float : right">${buyingList.i_bidding_p}</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶시작가<span style ="float : right;">원</span> <span style = "float : right">${buyingList.auc_sp}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶입찰 단위<span style ="float : right;"></span> <span  style = "float : right">${buyingList.auc_unit}원</span>
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶내 입찰가<span style ="float : right;"></span> <span  style = "float : right">${buyingList.myBidding_p}원</span>
		</div>	
		</div>
		</div>
	 	</c:forEach>
		</c:if> 
		<c:if test="${buyingSize > 0}">
		<div style = "text-align: center; diaplsy : inline; float : left; margin-top : 150px; margin-right : 300px;">
   <c:set var="pageCount" value="${buyingSize}"/>
   <c:set var="pageBlock" value="${5}"/>
   <fmt:parseNumber var="result" value="${bingPageNum / 5}" integerOnly="true" />
   <c:set var="startPage" value="${result * 5 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
   
   <div style="position: absolute; top:460px; left: 400px;">           
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/myAuction?bingPageNum=${startPage - 10 }&tab=구매">[이전]</a>
   </c:if>

    <c:forEach var="i" begin="${startPage}" end="${endPage}"> 
       <a href="/Treasure/S/myAuction.do?bingPageNum=${i}&tab=구매">[${i}]</a>
    </c:forEach> 

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/myAuction.do?bingPageNum=${startPage + 10}&tab=구매">[다음]</a>
   </c:if>
   </div>
   </div>
</c:if>
		
		<div style = "margin-top : 400px; width : 900px;">
		<h2>경매 마감</h2>
		<hr align="left" width ="700px">
		</div>
		<div>
		<c:if test = "${buyEndSize eq 0}">
		<div style = "width : 700px; position : abolute; border : 1px solid; text-align : center; top : 200px;" >
		경매 마감 된 구매 작품이 없습니다.
		</div>
		</c:if>
		 <c:if test = "${buyEndSize > 0}">
		<c:forEach var = "buyEndList" items = "${buyEndList}" begin = "${bEndPageNum-1}" end = "${bEndPageNum-1}"> 
		<div style = "width : 380px; display : inline; float : left;" >
		<img src = "${pageContext.request.contextPath}${buyEndList.auc_image}" style = "width : 350px; height : 300px;">
		</div>
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		
		<a href="/Treasure/S/auctionDetailEnd.do?auc_end_no=${buyEndList.auc_end_no}&&user_id=${buyEndList.user_id}"><h2 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >${buyEndList.auc_title}</h2></a><DIV id=count style="display: inline; float : right;">
				<h6 style = "color : red;">마감</h6>
				
			</div>
		</div>
		<c:if test="${buyEndList.auc_state eq 0 && buyEndList.bidding_p_rank < 4}">
		<div style = "display : inline; float : left; width : 300px;">경매결과 <span style = "float : right">${buyEndList.bidding_p_rank}순위 낙찰 성공</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶낙찰가<span style ="float : right;">원</span> <span style = "float : right">${buyEndList.myBidding_p}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶판매자<span style ="float : right;"></span> <span  style = "float : right">${buyEndList.user_id}</span>
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶구매 진행 상황<span style ="float : right;"></span> <span  style = "float : right">낙찰자 선정 중</span>
		</div>			
		</c:if>
		<c:if test="${buyEndList.auc_state eq 0 && buyEndList.bidding_p_rank > 3}"> 
		<div style = "display : inline; float : left; width : 300px;">경매결과<span style = "float : right">${buyEndList.bidding_p_rank}순위 낙찰 실패</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶내 입찰가<span style ="float : right;">원</span> <span style = "float : right">${buyEndList.myBidding_p}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶판매자<span style ="float : right;"></span> <span  style = "float : right">${buyEndList.user_id}</span>
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶구매 진행 상황<span style ="float : right;"></span> <span  style = "float : right; color : red;">낙찰 실패</span>
		</div>
		</c:if> 
		<c:if test="${buyEndList.auc_state eq 2 && buyEndList.e_bidder ne buyEndList.winner}">
		<div style = "display : inline; float : left; width : 300px;">경매결과 <span style = "float : right">${buyEndList.bidding_p_rank}순위 낙찰 성공</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶낙찰가<span style ="float : right;">원</span> <span style = "float : right">${buyEndList.myBidding_p}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶판매자<span style ="float : right;"></span> <span  style = "float : right">${buyEndList.user_id}</span>
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶구매 진행 상황<span style ="float : right;"></span> <span  style = "float : right; color : red;">최종 낙찰 실패</span>
		</div>		
		</c:if>
		<c:if test="${buyEndList.auc_state eq 2 && buyEndList.e_bidder eq buyEndList.winner}">
		<div style = "display : inline; float : left; width : 300px;">경매결과 <span style = "float : right">${buyEndList.bidding_p_rank}순위 낙찰 성공</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶낙찰가<span style ="float : right;">원</span> <span style = "float : right">${buyEndList.myBidding_p}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶판매자<span style ="float : right;"></span> <span  style = "float : right">${buyEndList.user_id}</span>
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶구매 진행 상황<span style ="float : right;"></span> <span  style = "float : right; color : blue;">최종 낙찰 성공</span>
		</div>
	
		<c:if test = "${buyEndList.review eq '선정중'}">
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px;">
		<input type="button" style = "background-color: white; width: 300px;" onClick = "writeReview()" value="구매 후기 작성">
		<form name = "review">
		<input type = "hidden" name = "e_bidder" value = "${buyEndList.e_bidder}">
		<input type = "hidden" name = "auc_end_no" value = "${buyEndList.auc_end_no}">
		<input type = "hidden" name = "auc_title" value = "${buyEndList.auc_title}">
		</form> 
		</div>
		</c:if>
		<c:if test = "${!empty buyEndList.review && buyEndList.review ne '선정중'}">
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; text-align: center; border : 1px solid;">구매 후기 작성 완료
		</div>
		</c:if>
		</c:if>	
		</div>
		 </c:forEach>
		</c:if> 
		 <c:if test="${buyEndSize > 0}"> 
		<div style = "text-align: center; diaplsy : inline; float : left; margin-top : 170px; margin-right : 300px;">
   <c:set var="pageCount" value="${buyEndSize}"/>
   <c:set var="pageBlock" value="${5}"/>
   <fmt:parseNumber var="result" value="${bEndPageNum / 5}" integerOnly="true" />
   <c:set var="startPage" value="${result * 5 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
   
   <div style="position: absolute; top:920px; left: 400px;">        
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/myAuction?bEndPageNum=${startPage - 10 }&tab=구매">[이전]</a>
   </c:if>

    <c:forEach var="i" begin="${startPage}" end="${endPage}"> 
       <a href="/Treasure/S/myAuction.do?bEndPageNum=${i}&tab=구매">[${i}]</a>
    </c:forEach> 

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/myAuction.do?bEndPageNum=${startPage + 10}&tab=구매">[다음]</a>
   </c:if>
   </div>
 </c:if> 
		</div>
		
	</div>

</body>
</html>