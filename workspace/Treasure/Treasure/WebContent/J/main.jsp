<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:if test="${sessionScope.memId eq 'admin'}">
	<tiles:insertDefinition name="header_admin"/> 
</c:if>
<c:if test="${sessionScope.memId ne 'admin'}">
	<tiles:insertDefinition name="header"/> 
</c:if>
<div class="all">
<div class="slideshow-container">


<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="../images/main4.jpg">
  <div class="text">Treasure는 크리에이터들의 작품 활동을 응원하고 
  <br> 가치있는 물건들을 함께 나누는 사이트입니다.
  </div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="../images/main5.jpg">
  <div class="text">여러분의 응원은 크리에이터들에게 힘이 됩니다.</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="../images/main1.jpg">
  <div class="text">지금 저희의 회원이 되셔서 당신이 좋아하게 될 작가와 작품을 만나보세요.</div>
</div>

</div>
<br>

<div style="text-align:center">
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
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 3000); // Change image every 2 seconds
}
</script>

</body>
</html> 

