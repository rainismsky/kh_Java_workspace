<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
<head>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link href="../css/pic.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<title>Creative Main</title>
</head>
<body background-color="black">
	<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
	<tiles:insertDefinition name="menu_c" />

	  <div class="right2" margin-top="20px" padding="20px">
   
   
      <!-- content field  -->
      <%int i = 1; %>
      <c:forEach var="article" items="${articleList}">
          <div class="slideshow-container" >
             <div class="mySlides fade"> 
               <center><h2 style="color :#0B3B17;">Creative Arts의 좋아요 수 &nbsp;<font color="#F6B352" size ="25px"><%=i %></font> 위 작품입니다. </font></h2></center>
               <a href = "/Treasure/J/show_detail.do?show_no=${article.show_no}&&user_id=${article.user_id}"> 
               <img src="${pageContext.request.contextPath}${article.show_image}"
                  style="width: 800px; height : 600px;" border-radius="10px"/> <br>
               <div class="content">
                  <h1>${article.show_title}</h1>  
                  <div style="position:absolute; right: 10px; top: 40px;">
                  <label><img src="../images/dia3.png" width="30px" height="30px" float="right"/>${article.countedLike}</label></div>
               </div>
				</a>
            </div>
         </div>
		 <%i++; %>
      </c:forEach>
      <br/><br/><br/><br/>
      <div style="text-align: center; position: absolute; bottom:30px; left: 400px;">
         <span class="dot"></span>
         <span class="dot"></span>
         <span class="dot"></span>
      </div>
   </div>

	<script>
		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			var dots = document.getElementsByClassName("dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			setTimeout(showSlides, 3000); // Change image every 2 seconds
		}
	</script>
</body>
</html>