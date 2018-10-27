<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Treasure</title>
</head>

<link rel='stylesheet' href='../E/style.css' media='screen' />
<link rel='stylesheet' href='../css/menu.css' type='text/css' />
<link rel='stylesheet' href='../css/head.css' type='text/css' />
<link rel='stylesheet' href='../css/box.css' type='text/css' />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>


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

		/* //blocksit define
		$(window).load(function() {
			$('#container').BlocksIt({
				numOfCol : 5,
				offsetX : 8,
				offsetY : 8
			});
		}); */

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

			/* if (conWidth != currentWidth) {

				tWidth = conWidth;
				$('#container').width(conWidth);
				$('#container').BlocksIt({
					numOfCol : col,
					offsetX : 8,
					offsetY : 8
				});
			} */
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
	<c:if test="${l_category_name eq 'Creative Arts'}">
	<tiles:insertDefinition name="menu_c" />
	</c:if>
	<c:if test="${l_category_name eq 'Retro Collections'}">
	<tiles:insertDefinition name="menu_r" />
	</c:if>
	<div class="right2">


		<c:if test="${count == 0 && searchOk ne 'y'}">
			<table width="700" height="100" border="1" cellpadding="0" cellspacing="0" style="position: relative; top: 50px;">
				<tr>
						<td align="center">전시중인 물건이 없습니다.
						</br>
						Treasure는 여러분의 소중한 물건을 기다립니다..</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${count == 0 && searchOk eq 'y'}">
			<table width="700" height="100" border="1" cellpadding="0" cellspacing="0" style="position: relative; top: 50px;">
				<tr>
						<td align="center">해당하는 작품이 없습니다.
						
				</tr>
			</table>
		</c:if>
<table border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td>
		<c:if test="${count > 0}">
			<br>
			<article>
				Catecory ▶  검색 ▶  ${search}</a>
			</article>
			<br>

			<div class="list">
			<c:forEach var="article" items="${articleList}">
			<div class="lay">
				<div class="grid">
					<div class="imgholder">
						<a href = "/Treasure/J/show_detail.do?show_no=${article.show_no}&&user_id=${article.user_id}"><img src="${pageContext.request.contextPath}${article.show_image}" style = "witdh : 230px; height : 230px;"/></a>
					</div>
					
					<a href = "/Treasure/J/show_detail.do?show_no=${article.show_no}&&user_id=${article.user_id}"><strong>${article.show_title}</strong></a>
				<p>${article.user_id}</p>
				<div style="text-align:right"><img src="../images/painteddia.png" style="width:20px">${article.total_like}</div>
					<%-- <div class="meta">${article.total_like}</div> --%>
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
					<a href="/Treasure/E/searchList.do?pageNum=${startPage - 10 }&l_category_name=${l_category_name}&s_category_name=${s_category_name}&search=${search}">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/Treasure/E/searchList.do?pageNum=${i}&l_category_name=${l_category_name}&s_category_name=${s_category_name}&search=${search}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a href="/Treasure/E/searchList.do?pageNum=${startPage + 10}&l_category_name=${l_category_name}&s_category_name=${s_category_name}&search=${search}">[다음]</a>
				</c:if>
			</c:if>
		</div>
	</td>
	</tr>
</table>
	</div>
</body>
</html>