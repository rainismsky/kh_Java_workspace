<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> --%>
<html>
<head>
<title>보육의 정석</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
/* .item {
	width: 500px;
	heigth: 500px;
} */
</style>

</head>
<body>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header"><!-- ******* -->
	<div>
	<jsp:include page="header.jsp" flush="false"/>
	</div>	
	<div class="android-content mdl-layout__content">
        <a name="top"></a>
        
        <div class="container">
  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${pageContext.request.contextPath}/imgSave/main01.jpg" alt="Los Angeles"  style="width: 1200px; height: 700px;" /><!-- style="width:100%; -->
    </div>
   
   	<c:forEach var="list" items="${list1 }">
		<c:set var="img" value="${list.main_img }" />

		<div class="item">
        <img src="${pageContext.request.contextPath}${fn:substring(img,85,120)}" alt="M_img" style="width: 1000px; height: 700px;">
      </div>
	</c:forEach>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
        
        
</div>	
	
	<div>
	<jsp:include page="footer.jsp" flush="false"/>
	</div>
	
</div>	
</body>
</html>

