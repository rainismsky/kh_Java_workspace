<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link href="../css/menu.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon" rel="stylesheet">
<style>
body{
	font-family: 'Do Hyeon', sans-serif;
	font-size: 18px;
	 }


</style>

<meta charset="UTF-8">
<title>나의 작품 올리기</title>

<!--  -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" type="text/javascript" language="javascript"></script>
<script src="jquery.MultiFile.js" type="text/javascript" language="javascript"></script>

<style>
.button {
  padding: 15px 25px;
  font-size: 20px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #F5ECCE;
  background-color: #0B3B17;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
  font-family: 'Do Hyeon', sans-serif;
}

.button:hover {
	background-color: #F5ECCE;
	color: #0B3B17;
    }

.button:active {
  background-color: #F5ECCE;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

a.button1 {
    color: rgba(30, 22, 54, 0.6);
    box-shadow: rgba(30, 22, 54, 0.4) 0 0px 0px 2px inset;
}

a.button1:hover {
    color: rgba(255, 255, 255, 0.85);
    box-shadow: rgba(30, 22, 54, 0.7) 0 0px 0px 40px inset;
}
</style>
<!-- select -->
<script type="text/javascript">
var rowIndex = 1;
var idIndex = 1;
function addFile(form) {
    if (rowIndex > 3)
       return false;

    idIndex++;
    rowIndex++;
    var getTable = document.getElementById("insertTable");
    var oCurrentRow = getTable.insertRow(getTable.rows.length);
    var oCurrentCell = oCurrentRow.insertCell(0);
    oCurrentCell.innerHTML = "<tr><td colspan=6><div class='MultiFile-wrap' id='MultiFile" + idIndex + "'><input type='file' class='multi with-preview MultiFile-applied' maxlength = '1' accept='gif|jpg|png' multiple id = 'MultiFile"+idIndex + "' NAME='filename" + rowIndex + "' value><div class='MultiFile-list' id='MultiFile" + idIndex + "_list'></div><div></td></tr>";
 }
 function deleteFile(form){
    if(rowIndex<2){
       return false;
    }else{
       rowIndex--;
       
    }
    var getTable = document.getElementById("insertTable");
    getTable.deleteRow(rowIndex);
 }
// 대분류
var firstList = new Array("== 창작품 / 레트로 ==", "Creative Arts","Retro Collections");

// 중분류

var secondList1 = new Array("미술","도자공예","가죽공예","금속공예","목재공예","유리공예","섬유공예");
var secondList2 = new Array("장식품","음악","영화","도서","게임","패션","전자기기","화폐","우표","피규어/프라모델");

// 페이지 로딩시 자동 실행  
window.onload = function(){
    var v_l_category_name = document.getElementById("l_category_name"); // SELECT TAG
      
    for (i =0 ; i<firstList.length; i++){// 0 ~ 3 
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");
  
        // option태그에 value 속성 값으로 저장
        optionEl.value = firstList[i];
      
        // text 문자열을 새로 생성한 <option> 태그의 값으로 추가
        optionEl.appendChild (document.createTextNode(firstList[i]));
      
        // 만들어진 option 태그를 <select>태그에 추가
        v_l_category_name.appendChild(optionEl);
    }
  
    var v_s_category_name = document.getElementById("s_category_name"); // SELECT TAG
    v_s_category_name.style.display = "none";  // 태그 감추기  
}

// 대분류 선택시
function changeL_category_name(){
    var v_l_category_name = document.getElementById("l_category_name"); // SELECT TAG
    var idx = v_l_category_name.options.selectedIndex;     // 선택값 0 ~ 3
     

    if (idx < 1 && idx > 3){
    	return;
    }
  	var k= document.writeForm.l_category.value;
  	document.writeForm.l_category.value = idx;
    k= document.writeForm.l_category.value;
    
    s_category_name_Fill(idx);   // 중분류 생성
}


function s_category_name_Fill(idx){
    var v_s_category_name = document.getElementById("s_category_name"); // SELECT TAG
    var v_secondSelect = document.getElementById("lastSelect");
 
    var data = null;  
  
    if (idx == 0) {
        v_s_category_name.style.display = "none";  // 중분류 태그 감추기
        v_secondSelect.style.display = "none";

    }
  
    if (idx == 1){
     data = secondList1
   
     }
    if (idx == 2){
     data = secondList2
     
     }
  

    v_s_category_name.innerHTML = "";  // 태그 출력
      
    for (i =0 ; i<data.length; i++){ 
        // 새로운 <option value=''>값</option> 태그 생성
        var optionEl = document.createElement("option");
  
        // value 속성 태그에 저장
        optionEl.value = data[i];
      
        // text 문자열을 새로 생성한 <option> 태그에 추가
        optionEl.appendChild (document.createTextNode(data[i]));
      
        // 만들어진 option 태그를 <select>태그에 추가
        v_s_category_name.appendChild(optionEl);
    }
  
v_s_category_name.style.display = ""; // 중분류 태그 출력
  

}

// 대분류 선택시
function changeSecondSelect(){
    var v_l_category_name = document.getElementById("l_category_name"); // SELECT TAG
    var v_secondSelect = document.getElementById("s_category_name"); // SELECT TAG
    var idx = v_l_category_name.options.selectedIndex; 
    var idx2 = v_secondSelect.options.selectedIndex;    // 선택값 0 ~ 3
     
    // alert("select: " + selText);
    if (idx < 1 && idx > 3){
        return;
    }
  
    /* document.getElementById('l_category_name').setAttribute('l_category', v_l_category_name) */  
      // 중분류 생성
	if (idx == 1){
    	console.log(firstList[idx],secondList1[idx2]);
    	//request.setAttribute("l_category_name", firstList[idx])
    	var j = document.writeForm.s_category.value;
    	document.writeForm.s_category.value = idx2;
    	j = document.writeForm.s_category.value;
    	//alert(document.writeForm.s_category.value);
    	document.writeForm.s_category.value=secondList1[idx2];
	}
	if (idx == 2){
    	console.log(firstList[idx],secondList2[idx2]);
    	var j = document.writeForm.s_category.value;
    	document.writeForm.s_category.value = idx2;
    	j = document.writeForm.s_category.value;
    	//alert(document.writeForm.s_category.value);
        }
       
       
   	
}
</script>
<!--  -->
</head>
<body>
<tiles:insertDefinition name="header" />
<tiles:insertDefinition name="menu_m" />
<div class="right2" style="width:850px;">
<h1>작품 올리기</h1>
<hr>
<form method="post" name="writeForm" id = "writeForm" action="/Treasure/P/writePro.do" enctype="multipart/form-data" 
onSubmit="return writeSave()" accept-charset="utf-8">

<script>
function previewFile() {
	  var preview = document.querySelector('img');
	  var file    = document.querySelector('input[type=file]').files[0];
	  var reader  = new FileReader();

	  reader.addEventListener("load", function () {
	    preview.src = reader.result;
	  }, false);

	  if (file) {
	    reader.readAsDataURL(file);
	  }
	  
	}
</script>






 <!-- 이미지 업로드 -->
 <!-- 
 <input type="file" onchange="previewFile()"><br>
<img src="" height="200" alt="Image preview...">

 -->
 이미지 업로드
 <br>
<!-- <input type="file" name="show_image" class="button" accept="image/*" onchange="loadFile(event)"/>
<img id="output" height="200"/>
 -->
 <table width="100%" id="insertTable">
                     <tr>
                        <td valign=bottom><input type="file" name = "filename1" class="multi with-preview" maxlength = "1" accept="gif|jpg|png" multiple /></td>
                        <td width=100><input type="button" value="추가" class="button"
                           onClick="addFile(this.form)" border=0 style='cursor: hand'>
                           <input type="button" value="삭제" onClick='deleteFile(this.form)' class="button"
                           border=0 style='cursor: hand'></td>
                     </tr>

                  </table>

 <script>
  var loadFile = function(event) {
	  var reader = new FileReader();
	    reader.onload = function(){
	      var output = document.getElementById('output');
	      output.src = reader.result;
	    };
	    reader.readAsDataURL(event.target.files[0]);
	  };
</script>

<!-- select box -->
<br/><br/><br/>
<div id="" margin-top="5px">
카테고리 선택
 <br>
    <select id="l_category_name" name="l_category_name"  onChange="changeL_category_name();">
    	<%-- <option value="<%=request.getAttribute("l_category_name") %>"> --%>
    </select>
  	
    <select id="s_category_name" name="s_category_name" onChange="changeSecondSelect();">     
    </select>
</div>
<br/><br/><br/>
<!-- 판매여부 -->
판매여부<br/>
<input type="radio" name="show_sale" value="yes"/> yes 
<input type="radio" name="show_sale" value="no"/> no
<br/><br/><br/>

<!-- hash tag -->
<h3>Hash Tag</h3>
<textarea border-style="solid" cols="30" rows="10" name="h_tag">
</textarea>
<br/><br/><br/>
<br/>
<hr color="#EFEDED">
<h3>제목 :</h3> <input type ="text" name="show_title" size="100" font-size="9pt">
<br/>
<h3> 내용 :</h3> <textarea cols="100" rows="30"name="show_content"></textarea>
<input type = "hidden" name="l_category" value="a">
<input type = "hidden" name="s_category">
<br/><br/>
<div padding-left="250px" transform="translate(200px,0)">
<input type="submit" value="등록" class="button">
<input type="button" value="돌아가기" class="button" onClick="window.location='/Treasure/list.jsp'">
</div>
<br/><br/><br/>
</form>
</div>
</body>
</html>