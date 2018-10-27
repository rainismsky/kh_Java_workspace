function writeSave(){
if(document.writeform.writer.value==""){
	alert("작성자를 입력하셈 : ");
	documentwriteform.writer.focus();
	return false;
}
if(document.writerform.subject.valu==""){
	alert("제목을 입력하셈 : ");
	return false;
	}
if(document.writeform.content.value==""){
	alert("내용을 입력하셈 : ");
	document.writeform.content.focus();
	return false;
}

if(document.writeform.passwd.value==""){
	alert("pw입력하셈 : ");
	document.writeform.passwd.focus();
	return false;
}
}
