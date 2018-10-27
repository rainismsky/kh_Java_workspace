<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
<script>
function cancel() {
	self.close();
}

function checkAnwer(form) {
	if(document.answerForm.subject.value==null || document.answerForm.subject.value=="") {
		alert("제목을 입력하여 주세요.");
	return false;
	}
	if(document.answerForm.content.value==null || document.answerForm.content.value=="") {
		alert("내용을 입력하여 주세요.");
		return false;
	}
	return true;
}
</script>
<title>답장하기</title>
</head>
<body>
<table style = "width : 400px; margin : 0 auto;">
<tr>
<td colspan="2" style = " border-bottom : 3px solid gray; text-align: center; height : 30px;" > <h3 style = "margin : 0;">받은 쪽지</h3>
</td>
</tr>
<tr>
<td style = "width : 200px; hegiht : 100x;">보낸사람
</td>
<td>${recieve_from_id}
</td>
</tr>
<tr>
<td style = "hegiht : 50px; width : 100px;" >제 목
</td>
<td>${recieve_subject}
</td>
</tr>
<tr style = "border : 1px solid gray;">
<td colspan = "2" style = "height : 100px; border : 1px solid gray;">${recieve_content}
</td>
</tr>
<tr>
<td style = "height : 50px;">
</tr>
<tr>
<td colspan="2" style = " border-bottom : 3px solid gray; text-align: center; height : 30px;" > <h3 style = "margin : 0;">답장하기</h3>
</td>
</tr>
<tr>
<td style = "hegiht : 100px; width : 100px;" >제 목
</td>
<td><form action= /Treasure/S/answerMessage.do method = "post" name = "answerForm" onSubmit = "return checkAnswer(this.form)"><input type = "text" name = "subject" Style = "width : 325px;"><input type = "hidden" name = "send_to_id" value = "recieve_from_id">
</td>
</tr>
<tr style = "border : 1px solid gray;">
<td colspan = "2"><textarea name = "content" style = "height : 100px; width : 100%"></textarea>
</td>
</tr>
<tr>
<td colspan = "2">
<input type = "submit" value = "쪽지 보내기" style = "background-color: white;" > <input type = "button" value = "닫기" style = "background-color: white;" onClick = "cancel()"> </form>
</td>
</tr>
</table>
</body>
</html>