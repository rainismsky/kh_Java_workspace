function writeSave(){

	if(document.commentform.content.value==""){
	  alert("내용을 입력하세요");
	  return false;
	}
	return true;
}