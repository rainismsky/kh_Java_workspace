<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/head.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet" type="text/css">
<title>Admin</title>
<script>

function goAnswer(form) {
	window.open('about:blank','answer','width=600,height=700');
	form.submit();
	
	}

function deleteMsg(form) {
	window.open('about:blank','delete','width=600,height=700');
	form.submit();
	}

</script>
<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<tiles:insertDefinition name="header_admin" />
<tiles:insertDefinition name="menu_admin" />
<div class = "right2" style = "margin-top : 20px;">
<a href="/Treasure/S/myRecieveMsgList.do"><button type="button" class="btn btn-outline-primary" style = "width : 100px; background-color: #0B3B17; color : white;">받은 쪽지함</button></a>
<a href="/Treasure/S/mySendMsgList.do"><button type="button" class="btn btn-outline-primary" style = "width : 100px; background-color: white;">보낸 쪽지함</button></a>
<table style = "border: 1px solid; width: 840px; max-height : 400px; text-align: center;">
<tr style = "background-color: gray; text-align: center; max-height : 50px;">
<td style = "background-color: gray; color : white; width : 100px;">받는 사람
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">보낸 사람
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">제목
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 240px;">내용
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">받은 시간
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">내용/답장
</td>
<td style = "background-color: gray; border-color: black; color : white; width : 100px;">삭제
</td>
</tr>


<c:if test="${recieveMsgSize eq 0 && searchOk ne 'y'}">
<tr>
<td colspan = "6">
현재 가입 된 회원이 없습니다.
<td>
</tr>
</c:if>
<c:if test="${recieveMsgSize eq 0 && searchOk eq 'y'}">
<tr>
<td colspan = "6" >
해당하는 검색 결과가 없습니다.
<td>
</tr>
</c:if>
 <c:forEach var="recieveMsgList" items="${recieveMsgList}" varStatus="status">
<c:if test="${status.count%2 eq 1}"> 
<tr style = "background-color: Lightgray;">
<td style = "background-color: Lightgray;">${recieveMsgList.recieve_to_id}
</td>
<td style = "background-color: Lightgray;">${recieveMsgList.recieve_from_id}
</td>
<td style = "background-color: Lightgray;">${recieveMsgList.recieve_title}
</td>
<td style = "background-color: Lightgray;">${recieveMsgList.recieve_content}
</td>
<td style = "background-color: Lightgray;">${recieveMsgList.recieve_time}
</td>
<td style = "background-color: Lightgray;"><form style = "margin-bottom : 0px;" method = "post" target ="answer" action = "/Treasure/S/answerMsgForm.do"><input type = "button" value = "내용/답장" onClick ="goAnswer(this.form)">
<input type = "hidden" name = "recieve_no" value = "${recieveMsgList.recieve_no}"><input type = "hidden" name = "recieve_from_id" value = "${recieveMsgList.recieve_from_id}"><input type = "hidden" name = "recieve_subject" value = "${recieveMsgList.recieve_content}"></form>
</td>
<td style = "background-color: Lightgray;"><form method = "post" target = "delete" action="/Treasure/S/deleteRecieveMessage.do" style = "margin-bottom : 0px;">
<input type = "button" value="삭제" size="10" onClick = "delete(this.form)"><input type = "hidden" name = "recieve_no" value = "${recieveMsgList.recieve_no}"></form>
</td>
</tr>
 </c:if> 
<c:if test="${status.count%2 eq 0}">
<tr style = "background-color: beige;">
<td style = "background-color: beige;">${recieveMsgList.recieve_to_id}
</td>
<td style = "background-color: beige;">${recieveMsgList.recieve_from_id}
</td>
<td style = "background-color: beige;">${recieveMsgList.recieve_title}
</td>
<td style = "background-color: beige;">${recieveMsgList.recieve_content}
</td>
<td style = "background-color: beige;">${recieveMsgList.recieve_time}
</td>
<td style = "background-color: beige;"><form style = "margin-bottom : 0px;" method = "post" target ="answer" action = "/Treasure/S/answerMsgForm.do"><input type = "button" value = "내용/답장" onClick ="goAnswer(this.form)">
<input type = "hidden" name = "recieve_no" value = "${recieveMsgList.recieve_no}"><input type = "hidden" name = "recieve_from_id" value = "${recieveMsgList.recieve_from_id}"><input type = "hidden" name = "recieve_subject" value = "${recieveMsgList.recieve_subject}"><input type = "hidden" name = "recieve_content" value = "${recieveMsgList.recieve_content}"></form>
</td>
<td style = "background-color: beige;"><form method = "post" target = "delete" action="/Treasure/S/deleteRecieveMessage.do" style = "margin-bottom : 0px;">
<input type = "button" value="삭제" size="10" onClick = "delete(this.form)"><input type = "hidden" name = "recieve_no" value = "${recieveMsgList.recieve_no}"></form>
</td>
</tr>
</c:if>
 </c:forEach> 
</table>
<div style = "float : left; margin-left : 380px;">
<c:if test="${count > 0}">
<c:if test="${searchOk ne 'y'}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
   </div>
   <div style = "margin-top : 30px;">
   <form method = "post" name = "Search" action="/Treasure/S/myRecieveMsgList.do" style = "height : 27px;">
   <select name = "category" style = "margin-top : 1px; margin-left : 250px; border : 1px solid gray; height : 26px;">
   <option value = "보낸사람">보낸사람</option>
   <option value = "제목">제목</option>
   <option value = "내용">내용</option>
   </select>
   <input type = "search" name = "recieveMsgSearch" style = "margin-right : 5px; height : 27px; "><input type = "submit" value = "검색" style = "background-color: white; margin-right : 10px;">
   <input type = "hidden" name = "searchOk" value = "y">
   </form>
   </div>
</c:if>
<c:if test="${searchOk eq 'y'}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${startPage - 10 }&searchOk=y&category=${category}&recieveMsgSearch=${recieveMsgSearch}">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${i}&&searchOk=y&category=${category}&recieveMsgSearch=${recieveMsgSearch}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/S/myRecieveMsgList.do?pageNum=${startPage + 10}&searchOk=y&category=${category}&recieveMsgSearch=${recieveMsgSearch}">[다음]</a>
   </c:if>
   </div>
   <div style = "margin-top : 30px;">
   <form method = "post" name = "Search" action="/Treasure/S/myRecieveMsgList.do" style = "height : 27px;">
   <select name = "category" style = "margin-top : 1px; margin-left : 250px; border : 1px solid gray; height : 26px;">
   <option value = "보낸사람">보낸사람</option>
   <option value = "제목">내용</option>
   <option value = "내용">내용</option>
   </select>
   <input type = "text" name = "recieveMsgSearch" style = "margin-right : 5px; height : 27px;" value = "${recieveMsgSearch}"><input type = "submit" value = "검색" style = "background-color: white; margin-right : 10px;">
   <input type = "hidden" name = "searchOk" value = "y">
   </form>
   </div>
</c:if>
</c:if>
</div>
</body>
</html>