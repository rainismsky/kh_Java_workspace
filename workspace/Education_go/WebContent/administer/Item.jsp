<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="color.jspf"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<html>
<head>
<style>
.content{
	position:absolute;
	border:red 2px solid;
	left:17.5%;
	width:81.5%;
	height:86%;
	bottom:2%; 
	overflow: auto;
}

.item_img{
	height: 100px;
	width: 130px;
	margin-left:32px;
	margin-top:15px;
}

.item{
	padding-bottom: 10px;
}

.item_count{
	padding-left:20px;
	padding-top:10px;
}

.text{
	padding-bottom: 10px;
	font-size: 20px;
}

</style>
<script>
	function item_add() {
		
		$(function() {
			if($("#real_user").val() == "admin"){
				url = "/Education/administer/ItemAdd.do";
				window.open(
							url,
							"post",
							"toolbar=no ,width=500 ,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
				
			} else{
				alert("권한이 없습니다.");
				return false;
			}
		 }); 
	}
	
	
	function item_modify() {
		
		$(function() {
			if($("#real_user").val() == "admin"){
				url = "/Education/administer/ItemModify.do";
				window.open(
							url,
							"post",
							"toolbar=no ,width=500 ,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
				
			} else{
				alert("권한이 없습니다.");
				return false;
			}
		 }); 
	}
	
	
	function item_delete() {
		
		$(function() {
			if($("#real_user").val() == "admin"){
				url = "/Education/administer/ItemDelete.do";
				window.open(
							url,
							"post",
							"toolbar=no ,width=500 ,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
				
			} else{
				alert("권한이 없습니다.");
				return false;
			}
		 }); 
	}
	
		
 	function abc(formName){
 		if(formName.item_count.value == ""){
 			alert("개수를 입력해주세요.");
 			return false;
 		}
 		
 		var con_test = confirm(formName.item_name.value+" "+formName.item_count.value+"개 대여 하시겠습니까?");
		
		if(con_test){
			alert("대여했습니다.");
			formName.action = "/Education/administer/ItemPro.do";
			formName.submit();
			
		} else{
			return false;
		}
	}
 	
 	function return1(formName){
		var con_test = confirm(formName.item_name3.value+" "+formName.item_count3.value+"개 반납 하시겠습니까?");

		if(con_test){
			alert("반납했습니다.");
			formName.action = "/Education/administer/ItemPro2.do";
			formName.submit();
			
		} else{
			return false;
		}
 	} 
 
</script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="style.css" rel="stylesheet" type="text/css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>보육의정석</title>
<% session.setAttribute("nav", 3); %>

</head>
<body>

<tiles:insertDefinition name="header"/>
<tiles:insertDefinition name="aside"/>
        
	<div class="content">
 		<br>
	    <div class="container">
			 <h2>비품현황</h2><!-- 부트스트랩 Hover Rows 참조! -->
			 <p>비품현황 확인, 추가 및 삭제할 수 있습니다.</p> 		 
			 <div id="item" align="center">
					<DIV id="content" style="width: 800px;">
						<table width="100%" border="0" cellspacing="1" cellpadding="1">
							<tr>
								<td align="right">
									<button class="btn btn-primary" onclick="item_add()" >비품등록</button>&nbsp;
									<button class="btn btn-info" onclick="item_modify()" >비품수정</button>&nbsp;
									<button class="btn btn-danger" onclick="item_delete()" >비품삭제</button>
									<input type="hidden" id="real_user" value="${sessionScope.real_user}"/>
								</td>
							</tr>
							<tr bgcolor="#CECECE">
								<td align="center">비품현황</td>
							</tr>
						</table>
					<form name="itemform" action="/Education/administer/ItemPro.do">
						<table width="100%" border="1" cellspacing="1" cellpadding="1" bgcolor="#F3F9D7" style="border: 1px solid #CED99C">
							<tbody>
								<c:set var="count1" value="1"/>
																				
								<tr>
								<c:forEach var="i" begin="0" end="${a }" items="${list }" >
								<form method="post">
									<c:set var="img1" value="${fn:substring(i.item_img,85,120)}" />
									<c:set var="img2" value="\itemSave\null" />
									<c:if test="${img1 eq img2 }">
										<c:set var="img1" value="/itemSave/다운로드.jpg" />	
									</c:if>
									<td width='25%' class="item">
										<div align="center" style="border-bottom: 1px solid #CED99C;">${i.item_name }</div>
										<input type="hidden" id="item_name" name="item_name" value=${i.item_name }/>
 										<div class="item_img"><img style="width: 100%; height: 100%;" src="${pageContext.request.contextPath}${img1}" /></div> 
										<div class="item_count">
											수량:${i.item_count }
											<input type="number" name="item_count" id="item_count" min="1" max="${i.item_count }" style="width:45px"/>&nbsp;
											<button onclick="abc(this.form)">대여</button>
										</div>
									</td>
									<c:set var="count1" value="${count1+1 }"/>
									<c:if test="${count1 == 5 }">								
								</tr>
								
								<c:set var="count1" value="1" />
								</c:if>
								</form>
								</c:forEach>

								</tr>
							</tbody>
						</table>
					</form>
				</DIV>
			 </div><br><br>
			 
		
		<div id="my_req">
         <table border="1" width="900" cellpadding="0" cellspacing="0"
            align="center">
            <thead>
               <tr height="40">
                  <td align="center" colspan="6">나의 예약 내역
                  <td>
               </tr>
               <tr height="30">
                  <td align="center" width="50">번 호</td>
                  <td align="center" width="300">예약기간</td>
                  <td align="center" width="250">비품명</td>
                  <td align="center" width="150">수 량</td>
                  <td align="center" width="150">반 납</td>
               </tr>
            </thead>
            <c:forEach var="list3" items="${list3}">
               <form name="vacation" method="post" action="/Education/administer/ItemPro.do">
                  <tr height="30">
                     <td align="center" width="50">${req_number2}
                        <c:set var="req_number2" value="${req_number2 + 1}" />
                     </td>
                     <td align="center" width="300">${list3.item_start }&nbsp;~&nbsp;${list3.item_end }</td>
                     <td align="center" width="250">${list3.item_name}
                     	<input type="hidden" name="item_name3" value=${list3.item_name } />
                     	<input type="hidden" name="item_count3" value=${list3.item_req_count } />
                     </td>
                     <td align="center" width="150">${list3.item_req_count }</td>
                     <td align="center" width="150">
                        <button class="btn btn-warning" onclick="return1(this.form)">&nbsp;&nbsp;반 납&nbsp;&nbsp;</button>
                     </td>
                  </tr>
               </form>
            </c:forEach>
         </table>
      </div><br><br>
			 		 
			 
			 
		<div id="req">
         <table border="1" width="900" cellpadding="0" cellspacing="0"
            align="center">
            <thead>
               <tr height="40">
                  <td align="center" colspan="6">전체 예약 내역
                  <td>
               </tr>
               <tr height="30">
                  <td align="center" width="50">번 호</td>
                  <td align="center" width="150">대여자</td>
                  <td align="center" width="300">예약기간</td>
                  <td align="center" width="250">비품명</td>
                  <td align="center" width="150" colspan="2">수량</td>
               </tr>
            </thead>
            <c:forEach var="list2" items="${list2}">
               <form name="vacation1" method="post" action="/Education/administer/ItemPro.do">
                  <tr height="30">
                     <td align="center" width="50">${req_number}
                        <c:set var="req_number" value="${req_number + 1}" />
                     </td>
                     <td align="center" width="150">${list2.t_name }</td>
                     <td align="center" width="300">${list2.item_start }&nbsp;~&nbsp;${list2.item_end }
                     </td>
                     <td align="center" width="250">${list2.item_name}
                     </td>
                     <td align="center" width="150">${list2.item_req_count }
                     </td>
                  </tr>
               </form>
            </c:forEach>
         </table>
      </div><br><br>
      
 
		</div>
	</div>
        
</body>
</html>