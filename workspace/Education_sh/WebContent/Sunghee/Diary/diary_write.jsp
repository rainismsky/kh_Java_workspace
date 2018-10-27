<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.time.LocalDate" %>
<c:set var="now_year" value="<%= LocalDate.now().getYear()%>" />
<html>
<head>
<title>일지페이지</title>


<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> 
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

 
<link href="/Education/Sunghee/plugins/summernote/summernote.css" rel="stylesheet"> 
<script src="/Education/Sunghee/plugins/summernote/summernote.js"></script>
<script src="/Education/Sunghee/plugins/summernote/lang/summernote-ko-KR.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$('#summernote').summernote({ 
			height: 300,          
			focus: true, 
			lang: 'ko-KR', 
			callbacks:{
					onImageUpload: function(files, editor, welEditable){
			            	sendFile(files[0],this);
				} 
			}
		});
	});

  	function sendFile(file, editor) {
		var data  = new FormData();
		data.append('file', file);
      	$.ajax({
        	data: data,
        	type: 'post',
        	url: '/Education/Sunghee/Diary/summernote_imageUpload.jsp',
        	cache: false,
        	contentType:false,
        	processData: false,
        	beforeSend:function(){
        		console.log("준비");
        	},
        	complete:function(){
				console.log("완료");        		
        	},
        	success: function(data){
        		console.log("[성공]"+data.url);
        	 	$('#summernote').summernote('insertImage',data.url); 
        	},
        	error: function(jqXHR, textStatus, errorThrown) {
	 	   		alert(jqXHR+"~"+textStatus+"~"+errorThrown);
			}
      	});
    } 
  	
  	function checking(){
  		
  		var userinput = eval("document.userinput");
  		
  		var dateList = new Array();
  		
  		<c:forEach var="date" items="${dateList}">
  			dateList.push("${date}");
  		</c:forEach>

  		for (var i = 0; i < dateList.length; i++) {
  		    if(dateList[i] == userinput.input_date.value){
  		    	alert("해당 일자의 일지가 있습니다.");
  		    	return false;
  		    }
  	  		console.log("진행"+i+"/"+userinput.input_date.value+"/"+dateList[i]);
  		}

  		var date = userinput.input_date.value;
  		var strarr = date.split('-');
  		userinput.d_yy.value = strarr[0];
  		userinput.d_mm.value = strarr[1];
  		userinput.d_dd.value = strarr[2];

  	}
  	
</script>

</head>
<body>
<a href="/Education/Diary/diary_list.do?s_no=${s_no}">뒤로</a>
<br><br>
<form method="get" action="/Education/Diary/dairy_writePro.do" onsubmit="return checking()" name="userinput">
		<input type="hidden" name="d_yy">
		<input type="hidden" name="d_mm">
		<input type="hidden" name="d_dd">
		<input type="hidden" name="s_no" value="${s_no}">

	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td><input type="date" name="input_date" min="2005-01-01" max="${now_year}-12-31" required></td>
		</tr>
		
		<tr>
			<td><input type="text" placeholder="제목" name="d_subject" width="#" required ></td>
		</tr>
		
		<tr>
			<td><textarea name="d_content" id="summernote">일지를 등록해주세요</textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='/Education/Diary/diary_list.do?s_no=${s_no}'"></td>
		</tr>
	</table>
</form>
</body>
<script>

</script>
</html>