<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Treasure</title>
</head>

<link rel='stylesheet' href='style.css' media='screen' />
<link rel='stylesheet' href='../css/menu.css' type='text/css' />
<link rel='stylesheet' href='../css/head.css' type='text/css' />
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="../list/blocksit.min.js"></script>


<script>
	$(document).ready(function() {
		//vendor script
		$('#header').css({
			'top' : -50
		}).delay(1000).animate({
			'top' : 0
		}, 800);

		$('#footer').css({
			'bottom' : -15
		}).delay(1000).animate({
			'bottom' : 0
		}, 800);

		//blocksit define
		$(window).load(function() {
			$('#container').BlocksIt({
				numOfCol : 5,
				offsetX : 8,
				offsetY : 8
			});
		});

		//window resize
		var currentWidth = 1100;
		$(window).resize(function() {
			var winWidth = $(window).width();
			var conWidth;
			if (winWidth < 660) {
				conWidth = 440;
				col = 2
			} else if (winWidth < 880) {
				conWidth = 660;
				col = 3
			} else if (winWidth < 1100) {
				conWidth = 880;
				col = 4;
			} else {
				conWidth = 1100;
				col = 5;
			}

			if (conWidth != currentWidth) {

				tWidth = conWidth;
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol : col,
					offsetX : 8,
					offsetY : 8
				});
			}
		});
	});
</script>


</head>
<body>

	<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
	<tiles:insertDefinition name="menu_a" />
	<div class="right2">


		<c:if test="${count == 0}">
			<table width="700" height="100" border="1" cellpadding="0" cellspacing="0" style="position: relative; top: 50px;">
				<tr>
						<td align="center">진행중인 경매가 없습니다.
						</br>
						Treasure는 여러분의 소중한 물건으로 만들어 집니다.</td>
				</tr>
			</table>
		</c:if>
<table border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td>
		<c:if test="${count > 0}">
		<br>
			<article>
				Auction ▶ ${l_category_name} ▶ 진행중인 경매</a>
			</article>
			<br>

			<div class="list">
				<c:forEach var="article" items="${articleList}">
					<div class="lay">
						<div class="grid">

							<div class="imgholder">
								<a href="/Treasure/S/auctionDetail.do?auc_ing_no=${article.auc_ing_no}&&user_id=${article.user_id}"><img src="${pageContext.request.contextPath}${article.auc_image}"style="witdh: 230px; height: 230px;" /></a>
							</div>
							<a href = "/Treasure/S/auctionDetail.do?auc_ing_no=${article.auc_ing_no}&&user_id=${article.user_id}"><strong>${article.show_title}</strong></a>
							<p>${article.auc_ing_no}</p>
							<div style="text-align: right">${article.auc_sp}</div>
							<div class="meta">${article.auc_start}</div>
							<div class="meta">${article.auc_end}</div>
						</div>
						</div>
				</c:forEach>
			</div>
		</c:if> 
	</td>
	</tr>
	<tr>
	<td>
		<div style="text-align: center;">
			<c:if test="${count > 0}">
				<c:set var="pageCount"
					value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
				<c:set var="pageBlock" value="${10}" />
				<fmt:parseNumber var="result" value="${currentPage / 10}"
					integerOnly="true" />
				<c:set var="startPage" value="${result * 10 + 1}" />
				<c:set var="endPage" value="${startPage + pageBlock-1}" />
				<c:if test="${endPage > pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>

				<c:if test="${startPage > 10}">
					<a href="/Treasure/E/auctionList.do?pageNum=${startPage - 10 }&l_category_name=${l_category_name}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/Treasure/E/auctionList.do?pageNum=${i}&l_category_name=${l_category_name}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="/Treasure/E/auctionList.do?pageNum=${startPage + 10}&l_category_name=${l_category_name}">[다음]</a>
				</c:if>
			</c:if>

		</div>
	</td>
	</tr>
</table>
	</div>
</body>
</html>