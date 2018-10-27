<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
	<title>선생님 마이페이지</title>
	
	
	<!-- 라운드레이아웃 -->
    <link href="/Education/Sunghee/plugins/layout/bootstrap.min.css" rel="stylesheet">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	
	<!-- 타임테이블 -->
    <link rel="stylesheet" href="/Education/Sunghee/plugins/Grible_timetable/styles/timetablejs.css">
    <script src="/Education/Sunghee/plugins/Grible_timetable/scripts/timetable.js"></script>
    
    <jsp:include page="/tiles/header.jsp" />
	<jsp:include page="/tiles/aside.jsp" />


	<script>
		function writeWS() {	
			document.domain = "localhost";
		    url = "/Education/Sunghee/Teacher/weeklyschedule_write.jsp"; 
		    open(url, "confirm", ",width=2000, height=500, toolbar=no, location=no,status=no,menubar=no,scrollbars=no,resizable=no");
		}
		
	</script>
	<style>
		.rounded-circle{ 
			border-radius:50%!important;
		}
		.defalut{
			padding: 4px;
	    	margin-bottom: 20px;
  		  	line-height: 1.42857143;
  		  	background-color: #fff;
   			border: 1px solid #ddd;
    		border-radius: 4px;
		}
	</style>

</head>

<body> 
<main class="mdl-layout__content mdl-color--grey-100">
	<div class="content">
		<div class="container">
			<br>
			
			<!-- 시간표 -->
			<div class="row">
				<div class="col-lg-12">
					<h5 class="my-4"><b>타임테이블</b></h5>
					<div class="defalut">
	          			<a href="#" onClick="writeWS()">추가</a>
	          			<div class="timetable">타임테이블</div>
          			</div>
        		</div>
			</div>
			<br>
			
			<!-- 학생프로필 -->
			<div class="row">
				<div class="col-lg-12">
          			<h5 class="my-4"><b>학생프로필</b></h5>
        		</div>
        		<c:forEach var="student" items="${studentList}">
        		<div class="col-lg-3 col-sm-6 text-center mb-4 ">
        			<div class="thumbnail">
          			<img class="img-fluid d-block mx-auto" src="${pageContext.request.contextPath}${student.s_img}" alt="프로필사진" width="200" height="200">
          			<h3>${student.s_name}<br><small>${student.s_birth}</small></h3>
          			<p><button type="button" class="btn btn-info" onclick="window.open('/Education/Diary/diary_list.do?s_no=${student.s_no}','학생페이지','width=screen.width, height=100%')">학생페이지로 이동</button>
					</p>
					</div>
        		</div>
        		</c:forEach>
			</div>
			
		</div>
	</div>
</main>
	<script>
		var timetable = new Timetable();
		timetable.setScope(9,19);													
		timetable.addLocations(['월요일', '화요일', '수요일', '목요일', '금요일']);	
		
		<c:forEach var="ws" items="${wsList}">
			var schedule = '[${ws.schedule}] ${ws.starttime}-${ws.endtime}';
			var starttime = '${ws.starttime}'.split(':');
			var start = new Date(2015,5,15,parseInt(starttime[0]),parseInt(starttime[1]));
			var endtime = '${ws.endtime}'.split(':');
			var end = new Date(2015,5,15,parseInt(endtime[0]),parseInt(endtime[1]));
			
			timetable.addEvent(schedule,'${ws.ws_day}',start,end,{ 
				onClick:function(event) {
							if(confirm("삭제하시겠습니까")){
								location.href="/Education/Tpage/weeklyscheduledelete.do?ws_num=${ws.ws_num}";
							}
						} 
			});
		</c:forEach>  
		
	    var renderer = new Timetable.Renderer(timetable);
	    renderer.draw('.timetable');
	</script>
</body>
</html>