<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>보육의 정석</title>

<!-- <style>
.android-be-together-section {
  position: relative;
  height: 800px;
  width: auto;
  background-color: #f3f3f3;
  background: url('${pageContext.request.contextPath}/imgSave/main_top.jpg') center 30% no-repeat;
  background-size: cover;
}
</style> -->

<style>
#out {
 width: 100%;
 text-align: center;
 }
#in {
 display: inline-block;
 }
</style>

</head>
<body>

<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header"><!-- ******* -->
	<div>
	<jsp:include page="header.jsp" flush="false"/>
	</div>
	<div class="android-content mdl-layout__content">
        <a name="top"></a>
     
    <!-- ******* -->   
    <div id="out">
        <c:forEach var="list" items="${list1 }">
		<c:set var="img" value="${list.main_img }" />
		<%-- ${fn:substring(img,85,100)} --%>
			<div class="item" id="in">
       <img src="${pageContext.request.contextPath}${fn:substring(img,85,120)}" alt="M_img" style="width: 1000px; height: 700px;">
      		</div>
		</c:forEach>
    </div>    
      	
	<!-- ******* -->
</div>	
	
	<div>
	<jsp:include page="footer.jsp" flush="false"/>
	</div>
	</div>

</body>
</html>

