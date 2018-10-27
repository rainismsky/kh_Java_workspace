<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<script>


function auctionOk(form) { 
	if(document.form.auc_sp.value == "" || document.form.auc_sp.value == null) {
		alert("시작가를 입력하여 주세요.");
		return false;
	}
	if(document.form.auc_unit.value == "" || document.form.auc_unit.value == null) {
		alert("입찰 단위를 입력하여 주세요.");
		return false;
	}
	if(document.form.auc_start.value == "" || document.form.auc_start.value == null) {
		alert("경매 시작일을 입력하여 주세요.");
		return false;
	}
	if(document.form.auc_endDay.value == "" || document.form.auc_endDay.value == null) {
		alert("경매 마감일을 입력하여 주세요.");
		return false;
	}
	if(document.form.auc_endDay.value == "" || document.form.auc_endDay.value == null) {
		alert("경매 마감시간을 입력하여 주세요.");
		return false;
	}
	return true;
	alert("경매 등록이 완료 되었습니다.");
	window.location.reload();
	
	} 

</script>
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
			<a href="/Treasure/S/myAuction.do?tab=경매가능"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: #0B3B17; color : white;">경매 가능</button></a>
			<a href="/Treasure/S/myAuction.do?tab=판매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">판매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=구매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">구매</button></a>
			<a href="/Treasure/S/myAuction.do?tab=관심경매"><button type="button" class="btn btn-outline-primary" style = "width : 80px; background-color: white;">관심 경매</button></a>
	</div>
		<div style = "margin-top : 55px; width : 900px;">
		<h2>경매 등록 가능 작품</h2>
		<hr align="left" width ="700px">
		</div>
		<c:if test = "${empty aucOkList}">
		<div style = "width : 700px; display : inline; float : left; border : 1px solid; text-align : center;" >
		경매 등록 가능한 작품이 없습니다.
		</div>
		</c:if>
		<c:forEach var = "aucOkList" items = "${aucOkList}">
		<div style="width: 1100px; position: relative; float: left;">
		<div style = "width : 380px; display : inline; float : left; margin-top : 5px;" >
		<img src = "${pageContext.request.contextPath}${aucOkList.show_image}" style = "width : 350px; height : 300px;">
		</div>	
		<div style = "width : 300px; display : inline; float : left;">
		<div>
		<form method = "post" name = "auctionOkForm" action = "/Treasure/S/auctionOk.do" onSubmit = "return auctionOk(this.form)" >
		<a href = "/Treasure/J/show_detail.do?show_no=${aucOkList.show_no}"><h3 style = "display : inline; float : left; margin-top : 2px; text-align: left;" >${aucOkList.show_title}</h3></a><input type = "submit" style = "display : inline; background-color: sky; width : 80px; margin-left : 10px; margin-top : 3px;" value = "경매등록">
		</div>
			
		<div style = "display : inline; float : left; width : 300px;">▶시 작 가<span style ="float : right;">원</span> <input type = "text" name = "auc_sp" size = "15" style = "float : right">
		</div>
		<div style = "margin-top : 15px; display : inline; float : left; width : 300px;">▶입찰 단위<span style ="float : right;">원</span> <input type = "text" name = "auc_unit" size = "15" style = "float : right">
		</div><br>
		<div style = "margin-top : 15px; display : inline; float : left; width : 300px;">▶경매 시작일<span style ="float : right;"></span> <input type="date" id = "auc_start" name = "auc_start" size = "8" style = "float : right">
		</div>
		<div style = "margin-top : 15px; display : inline; float : left; width : 300px;"><span style ="float : left;">▶경매 마감일</span> <input type="date" name = "auc_endDay" size = "8" style = "float : right;"> 
		</div>
		<div style = "margin-top : 15px; display : inline; float : left; width : 300px;"><span style ="float : left;">▶경매 마감시간</span><input type="time" name = "auc_endTime" size = "8" style = "float : right;"><input type = "hidden" name = "show_no" value = "${aucOkList.show_no}">
		</div>
		</form>
		</div>
		</div>
		<hr width = "700px" style = "margin-top : 15px; display : inline; float :left;">
		</c:forEach> 
	</div>

</body>
</html>