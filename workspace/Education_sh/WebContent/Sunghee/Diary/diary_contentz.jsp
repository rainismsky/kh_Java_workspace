<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>일지페이지</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>

	
	function del(){
	
		if(confirm("삭제하시겠습니까")){
			return true;
		}else{
			return false;
		}
	}

</script>

</head>
<body>
<div id="dd">여기출력!</div>
	<a
		href="/Education/Diary/diary_list.do?s_no=${article.s_no}&d_yy=${article.d_yy}&d_mm=${article.d_mm}">뒤로</a>
	<br>
	<br>
	<div align="center">

		<form id="writeDcForm" style="display: inline">
		
			<input type="hidden" value="${d_num}" name="d_num" id="d_num"> 
			<table border="1" cellpadding="0" cellspacing="0" width="500"
				height="#">
				<tr>
					<td align="center" colspan="2">${article.d_subject}</td>
				</tr>
				<tr>
					<td height="100" colspan="2">${article.d_content}</td>
				</tr>
				<tr>
					<td><textarea id="dc_content" name="dc_content" placeholder="댓글" rows="4" cols="50"></textarea></td>
					<td><input type="button" value="등록" id="write_dc_button"></td>
				</tr>
			</table>
		</form>

		<table border="1" cellpadding="0" cellspacing="0" width="500" height="#">
			<c:choose>
				<c:when test="${empty commentList}">
					<tr>
						<td>--</td>
						<td>댓글이 아직 없습니다.</td>
						<td>--/--/--</td>
					</tr>
				</c:when>

				<c:otherwise>
					<div id="dc_view"></div>	
					<c:forEach var="comment" items="${commentList}">
						<tr>
							<td>
								<c:if test="${fn:contains(comment.commenter,'teacher')}"> 담당선생님</c:if>
								<c:if test="${fn:indexOf(comment.commenter,'teacher') == -1}"> 학부모님</c:if>
							</td>
							<td colspan="2">${comment.dc_content}<br>
							<small>(${comment.dc_reg_date}) 
									<c:if test="${sessionScope.id == comment.commenter}">
										<a href="/Education/Diary/dairy_commentupdate.do?dc_num=${comment.dc_num}">수정</a>
										<a href="/Education/Diary/dairy_commentdelete.do?dc_num=${comment.dc_num}" onclick="return del()">삭제</a>
									</c:if>
							</small></td>
						</tr>
						<div id="test_div"></div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>