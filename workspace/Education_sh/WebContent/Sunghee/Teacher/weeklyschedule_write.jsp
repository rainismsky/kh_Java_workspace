<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>시간표 추가</title>

    <!-- 타임시간하고 분만 받아오기 -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js" type="text/javascript" ></script>
	<script src=" https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript" ></script>
    <link rel="stylesheet" href="/Education/Sunghee/plugins/jquery-timepicker-1.3.5/jquery.timepicker.css">
    <script src="/Education/Sunghee/plugins/jquery-timepicker-1.3.5/jquery.timepicker.min.js"></script>
    
	<script type='text/javascript'> 
	$(document).ready(function(){
		$('input.timepicker').timepicker({
		    timeFormat: 'HH:mm',
		    interval: 30,
		    minTime: '09:00',
		    maxTime: '18:00',
		    defaultTime: '09:00',
		    startTime: '09:00',
		    dynamic: false,
		    dropdown: true,
		    scrollbar: false
		});
	});
	

	function check(){
		document.domain = "localhost"; 
		opener.name = "openerNames";
	    document.forms.ws_form.target = opener.name;
	    document.forms.ws_form.submit();
	    self.close();
	}
	
	</script>
</head>
<body>

<form name="ws_form" method="get" action="/Education/Tpage/weeklyschedulewrite.do" onsubmit="return check()" >
	<fieldset>
		<legend>시간표 추가</legend>
		<ul>
			<li>요일 지정: <select name="ws_day" required>
							<option value="월요일">월요일</option>
							<option value="화요일">화요일</option>
							<option value="수요일">수요일</option>
							<option value="목요일">목요일</option>
							<option value="금요일">금요일</option>
						</select>
			<li>시작 시간: <input class="timepicker" name="starttime" required />
			<li>종료 시간: <input class="timepicker" name="endtime" required />
			<li>등록 정보: <input type="text" name="schedule" required />
			<li><input type="submit" value="등록">
		</ul>
	</fieldset>
</form>

</body>
</html>