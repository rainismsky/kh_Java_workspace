<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<SCRIPT> 

function selectWinner1() {
    var url = "/Treasure/S/setWinner.do?auc_end_no=" + winners.auc_end_no.value + "&&e_bidder=" + winners.winner1.value;    
    window.open(url, "select1", "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=400");
    return false;	
}


function selectWinner2(){
	   // url과 사용자 입력 id를 조합합니다.
	 url = "/Treasure/S/setWinner.do?auc_end_no=" + winners.auc_end_no.value + "&&e_bidder=" + winners.winner2.value;
	 
	 // 새로운 윈도우를 엽니다.
	 window.open(url, "select2", 
	 "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=400");
	 return false;

}

function selectWinner3(){
	   // url과 사용자 입력 id를 조합합니다.
	 url = "/Treasure/S/setWinner.do?auc_end_no=" + winners.auc_end_no.value + "&&e_bidder=" + winners.winner3.value;
	 
	 // 새로운 윈도우를 엽니다.
	 window.open(url, "select3", 
	 "toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=700, height=400");
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
	} 



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
			<a href="/Treasure/S/myAuction.do?tab=판매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: #0B3B17; color : white;">판매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=구매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">구매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=관심경매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">관심 경매</button></a>
		</div>
		<div style = "margin-top : 55px; width : 900px;">
		<h2>경매 진행 중</h2>
		<hr align="left" width ="700px">
		</div>		
		<div >
		<c:if test = "${sailingSize eq 0}">
		<div style = "width : 700px; position : abolute; border : 1px solid; text-align : center; top : 200px;" >
		경매 진행 중인 판매 작품이 없습니다.
		</div>
		</c:if>
		 <c:if test = "${sailingSize > 0}">
		<c:forEach var = "sailingList" items = "${sailingList}" begin = "${singPageNum-1}" end = "${singPageNum-1}"> 
		<div style = "width : 380px; display : inline; float : left;" >
		<img src = "${pageContext.request.contextPath}${sailingList.auc_image}" style = "width : 350px; height : 300px;">
		</div>
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		
		<a href="/Treasure/S/auctionDetail.do?auc_ing_no=${sailingList.auc_ing_no}&&user_id=${sailingList.user_id}"><h2 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >${sailingList.show_title}</h2></a><DIV id=count style="display: inline; float : right;">
				<h6><SPAN style="FONT: bold 12px Gulim; COLOR: #000" id=counter0></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">일</FONT><SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter1></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">시간</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter2></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">분</FONT> <SPAN
					style="FONT: bold 12px Gulim; COLOR: #000" id=counter3></SPAN><FONT
					style="FONT-FAMILY: '굴림'; size: 7px">초 남음</FONT></h6>
				
			</div>
		</div>
		<form name = "time"><input type = "hidden" name = "timer" id = "timer" value = "${sailingList.auc_end}"></form>
		<SCRIPT>getTime()</SCRIPT>
		<br>
		<div style = "display : inline; float : left; width : 300px; margin-top : 15px;">▶최고 입찰가<span style ="float : right;">원</span> <span style = "float : right">${sailingList.i_bidding_p}</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶시작가<span style ="float : right;">원</span> <span style = "float : right">${sailingList.auc_sp}</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶입찰 단위<span style ="float : right;">원</span> <span  style = "float : right">${sailingList.auc_unit}</span>
		</div>		
		</div>
		</div>
		 </c:forEach>
		</c:if> 
		<c:if test="${sailingSize > 0}">
		<div style = "text-align: center; diaplsy : inline; float : left; margin-top : 170px; margin-right : 300px;">
   <c:set var="pageCount" value="${sailingSize}"/>
   <c:set var="pageBlock" value="${5}"/>
   <fmt:parseNumber var="result" value="${singPageNum / 5}" integerOnly="true" />
   <c:set var="startPage" value="${result * 5 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
    
    <div style="position: absolute; top:460px; left: 400px;">     
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/myAuction?singPageNum=${startPage - 10 }&&tab=판매">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/myAuction.do?singPageNum=${i}&&tab=판매">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/myAuction.do?singPageNum=${startPage + 10}&&tab=판매">[다음]</a>
   </c:if>
   </div>
   </div>
</c:if>
		
		<div style = "margin-top : 400px; width : 900px;">
		<h2>경매 마감</h2>
		<hr align="left" width ="700px">
		</div>
		<div>
		<c:if test = "${sailEndSize eq 0}">
		<div style = "width : 700px; display : inline; float : left; border : 1px solid; text-align : center;" >
		경매 마감 된 판매 작품이 없습니다.
		</div>
		 </c:if>
		 <c:if test = "${sailEndSize > 0}">
		<c:forEach var = "sailEndList" items = "${sailEndList}" begin = "${sEndPageNum-1}" end = "${sEndPageNum-1}"> 
		<div style = "width : 380px; display : inline; float : left;" >
		<img src = "${pageContext.request.contextPath}${sailEndList.auc_image}" style = "width : 350px; height : 300px;">
		</div>
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		<a href="/Treasure/S/auctionDetailEnd.do?auc_end_no=${sailEndList.auc_end_no}&&user_id=${sailEndList.user_id}"><h2 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >${sailEndList.auc_title}</h2></a><DIV id=count style="display: inline; float : right;">
				<h6>마감</h6>
				
			</div>
		</div>
		  <c:if test="${sailEndList.auc_state eq 0}">  
		<br>
		<div style = "display : inline; float : left; width : 300px;">경매 결과<span style ="float : right;">최종 낙찰자 선택 가능</span>
		</div><form name = "winners">
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶1순위 낙찰자<a href = "#" onClick = "selectWinner1(this.href); return false;">
		<span style ="float : right;">${sailEndList.e_bidder1}</span></a>
		<span style = "float : right">${sailEndList.e_bidding_p1}원</span>
		<input type = "hidden" name = "winner1" value="${sailEndList.e_bidder1}">
		<input type = "hidden" name = "auc_end_no" value = "${sailEndList.auc_end_no}">
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶2순위 낙찰자<a href = "#" onClick = "selectWinner2(this.href); return false;">
		<span style ="float : right;">${sailEndList.e_bidder2}</span></a> 
		<span  style = "float : right">${sailEndList.e_bidding_p2}원</span>
		<input type = "hidden" name = "winner2" value="${sailEndList.e_bidder2}">
		</div>	
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶3순위 낙찰자<a href = "#" onClick = "selectWinner3(this.href); return false;">
		<span style ="float : right;">${sailEndList.e_bidder3}</span></a>
		<span  style = "float : right">${sailEndList.e_bidding_p3}원</span>
		<input type = "hidden" name = "winner3" value="${sailEndList.e_bidder3}">
		</div></form>	
		  </c:if>  
		<c:if test="${sailEndList.auc_state eq 1}">
			<div style = "display : inline; float : left; width : 300px; margin-top : 15px;">▶경매 결과<span style ="float : right; color = red;" >유찰</span>
		</div>
		</c:if>
		 <c:if test="${sailEndList.auc_state eq 2}"> 
				<div style = "display : inline; float : left; width : 300px; margin-top : 15px;">▶경매 결과<span style ="float : right;">최종 낙찰 완료</span>
		</div>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶낙찰 금액<span style ="float : right;">낙찰가${sailEndList.win_price}원</span>
		</div><br>
		<div style = "margin-top : 5px; display : inline; float : left; width : 300px; margin-top : 15px;">▶최종 낙찰자<a href = "피드로 이동"><span style ="float : right;">${sailEndList.winner}</span></a> 
		</div>		
		</c:if>
		</div>
	 </c:forEach>
	</c:if>  
		
			<c:if test="${sailEndSize > 0}">
			<div style = "text-align: center; diaplsy : inline; float : left; margin-top : 170px; margin-right : 300px;">
   <c:set var="pageCount" value="${sailEndSize}"/>
   <c:set var="pageBlock" value="${5}"/>
   <fmt:parseNumber var="result" value="${sEndPageNum / 5}" integerOnly="true" />
   <c:set var="startPage" value="${result * 5 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
   
   <div style="position: absolute; top:920px; left: 400px;">     
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/MyAuction?sEndPageNum=${startPage - 10 }&&tab=판매">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/MyAuction.do?sEndPageNum=${i}&&tab=판매">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/MyAuction.do?sEndPageNum=${startPage + 10}&&tab=판매">[다음]</a>
   </c:if>
</c:if>
</div>
</div>
		</div>

</body>
</html>