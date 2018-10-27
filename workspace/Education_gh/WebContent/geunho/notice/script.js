function writeSave(){

if(document.writeform.n_num.value==""){
  alert("글을 입력하십시요.");
  document.writeform.n_num.focus();
  return false;
}
if(document.writeform.n_subject.value==""){
  alert("제목을 입력하십시요.");
  document.writeform.n_subject.focus();
  return false;
}
if(document.writeform.n_content.value==""){
  alert("내용을 입력하십시요.");
  document.writeform.n_content.focus();
  return false;
}
if(document.writeform.n_readcount.value==""){
  alert("조회수를 입력하십시요.");
  document.writeform.n_readcount.focus();
  return false;
}
if(document.writeform.n_reg_date.value==""){
	  alert("작성일을 입력하십시요.");
	  document.writeform.n_reg_date.focus();
	  return false;
	}
}   
