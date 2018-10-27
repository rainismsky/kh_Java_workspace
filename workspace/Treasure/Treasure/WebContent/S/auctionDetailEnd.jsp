<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<title>${adbe.auc_title}</title>
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
<p>Category ▶ Auction ▶ ${adbe.l_category_name} ▶ 마감 경매</p>
<div class="slideshow-container"> 
	<c:forTokens items="${adbe.auc_image}" delims="," var="auc_image">
  	<div class="mySlides fade">
    <img src = "${pageContext.request.contextPath}${auc_image}" style=" width : 500px; height : 500px;" ></img>
	</div>
  </c:forTokens>
  <!-- Next and previous buttons -->
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
  <c:forEach varStatus = "status" begin = "1" end = "${lengthimg}"> 
  <span class="dot" onclick="currentSlide(${status.current})"></span> 
  <!-- <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
  <span class="dot" onclick="currentSlide(4)"></span>  -->
  </c:forEach>
</div>
<script language="JavaScript" src="${pageContext.request.contextPath}/S/slide.js"></script>
		<div style="margin-left : 15px; width: 300px; height: 500px; display: inline; float: left;">
			<c:set var="bidderMap" value="${bidderMap}" />
			<h1 style="display: inline;">${adbe.auc_title}</h1>
			<DIV id=count style="display: inline;">
				<SPAN style="FONT: bold 12px Gulim; COLOR: red;" id=counter0 style = "float : right;">마감</SPAN>
			</div>
			<br>
			<hr>
			
			<div>
				<h3>상위 입찰가</h3>
				<span>1순위 입찰가 ${bidderMap.bidp0}원</span><br> <span>2순위 입찰가 ${bidderMap.bidp1}원</span><br>
				<span>3순위 입찰가 ${bidderMap.bidp2}원</span>
			</div>
			<div>
				<h3>About the Auction</h3>
				<span>시작가</span><span style="float: right;">원</span><span
					style="float: right;">${adbe.auc_sp}</span><br> <span>입찰
					단위</span><span style="float: right;">원</span><span style="float: right;">${adbe.auc_unit}</span><br>
				<span>내 입찰가</span><span style="float: right;">원</span><span
					style="float: right;">${bidderMap.mybidp}</span><br> <span>경매
					참가자</span><span style="float: right;">명</span><span style="float: right;">${bidderMap.countbid}</span><br>
			</div>
			<br>
			<div style="width: 300px; display: inline; text-align: center; ">
			<c:if test="${adbe.auc_state eq 0}"><h2 style = "color : blue; border : 1px solid black;">낙찰자 선정중</h2></c:if>
			<c:if test="${adbe.auc_state eq 1}"><h2 style = "color : red; border : 1px solid black;">유찰</h2></c:if>
			<c:if test="${adbe.auc_state eq 2}"><h2 style = "color : black; border : 1px solid black;">최종 낙찰가 ${adbe.win_price}원</h2></c:if>
			</div>
		</div>			
		
		<div style = "width:800px; height:300px; display : block;">
<div style = "width:500px; height :25%; dispaly:inline; float:left; margin-top : 0px;">
<h3 style = "margin-bottom : 0px;"">About the Artist</h3>
<hr>
<table border="0" width="500" cellpadding="0" cellspacing="0" align="center" height="80" style="margin-bottom: 10px;">
   <tr>
      <td width="100" align="center" style="font-weight: bold;">
      <a href="/Treasure/J/otherfeed.do?user_id=${adbe.user_id}"><img class="photo" src="${pageContext.request.contextPath}${adbe.user_photo}" style="width:40px"><br>
      ${adbe.user_id}</a>
      </td>
      <td width="500">
      ${adbe.user_introduction}
      </td>
      <td width="200" align="right">     
     <!--  <a href = "#"><h5 style = "margin-bottom : 3px;">쪽지보내기</h5></a> -->
      </td>
   </tr>
</table>
<c:if test="${adbe.auc_state eq 2 && adbe.review ne '선정중'}">
<div style = "width : 800px; height : 300px;">
<table style = "width :800px; height : 15px; border-bottom : 1px;">
<tr>
<td style = "border-bottom : 1px solid gray;">
<h3 style = "margin-bottom : 0px;">구매 후기</h3>
</td>
</tr>
<tr>
<td style = "height : 5px;">
</td>
</tr>
</table>
<table border="0" width="800" cellpadding="0" cellspacing="0" align="center" height="80" style="background-color: #EAEAEA; margin-bottom: 10px;">
   <tr>
      <td width="100" align="center" style="font-weight: bold;">
      <a href="/Treasure/J/otherfeed.do?user_id=${adbe.winner}"><img class="photo" src="${pageContext.request.contextPath}${adbe.winner_photo}" style="width:40px"><br>
      ${adbe.winner}</a>>
      </td>
      <td width="500">
      ${adbe.review}
      </td>
      <td width="200" align="right">
      <fmt:formatDate value="${adbe.review_date}" pattern="yyyy-MM-dd, HH:mm:ss"/> &nbsp;
      </td>
   </tr>
</table>
</div>
</c:if> 
</div>
</div>
</div>

</body>
</html>