<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>일지페이지</title>


    <!-- FontAwesome JS-->
    <script defer src="https://use.fontawesome.com/releases/v5.1.1/js/all.js" integrity="sha384-BtvRZcyfv4r0x/phJt9Y9HhnN5ur1Z+kZbKVgzVBAlQZX4jvAuImlIz+bG7TS00a" crossorigin="anonymous"></script>

	<!-- 코멘트 -->
	<link href="/Education/Sunghee/plugins/layout/comment.css" rel="stylesheet">

    <!-- Theme CSS --> 
	<link id="theme-style" rel="stylesheet" href="/Education/Sunghee/plugins/layout/pillar-3.css">
	
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- 썸머노트 -->
	<link href="/Education/Sunghee/plugins/summernote/summernote.css" rel="stylesheet"> 
	<script src="/Education/Sunghee/plugins/summernote/summernote.js"></script>
	
	<script>

	/*
		$(function(){
			$("#dc_write_button").click(function(){
				
			}
				
				 else{
					$.ajax({
						url:"/Education/Diary/dairy_commentwrite.do",
						type:"get",
						data: {	"d_num": $("#d_num").val(),
								"dc_content": $("#dc_content").val()},
						dataType:'json',
						cache: false,
						beforeSend:function() {
		                    console.log("시작 전...");
		                },
		                complete:function() {
		                    console.log("완료 후...");
		                },
		                success : function(data) {
		                	console.log("들어옴"+data.result);
		                    if(data.result == 1) {            
		                        console.log("comment가 정상적으로 입력되었습니다.");
		                        console.log(data.comments);
		                        $("#dc_content").val("");
		                        showHtml(data.comments);
		                    }
						},
						error : function(xhr, textStatus, errorThrown) {
							alert(textStatus + " // " + xhr.status + " // " + errorThrown);
							$("#showComment").html("<div>" + textStatus + " (HTTP-" + xhr.status + " / " + errorThrown + ")</div>");
						}
					});
				}
			}); 
		}); 
	
	  	function showHtml(data) {
	  		console.log("들어옴"+data[0].commenter);
	  		console.log("들어옴"+data);
	  		
	        let html = "<table border='1' cellpadding='0' cellspacing='0' width='500' height='500'><tbody>";
	        $.each(data, function(index, item) {
	            html += "<tr align='center'>";
	            html += "<td>"+item.commenter+"</td>";
	            html += "<td>"+item.dc_content+"<br><small>+"+item.dc_reg_date;
					<c:if test="${sessionScope.id == item.commenter}">
				html += "<a href='/Education/Diary/dairy_commentupdate.do?dc_num=${comment.dc_num}'>수정</a>"
				html +=	"<a href='/Education/Diary/dairy_commentdelete.do?dc_num=${comment.dc_num}'>삭제</a>"
					</c:if>
				html += "</small></td>";
				html += "</tr>";
	        });
	        html += "</tbody></table>";
	
	        
	        $("#showComment").html(html);
	        $("#dc_content").focus();
	    } 
	
	*/
		function del(){
			if(confirm("삭제하시겠습니까")){
				return true;
			}else{
				return false;
			}
		}
		
		$(document).ready(function() {
	
			$('.comment_Edit').click(function(){
				var id = jQuery(this).attr('id');
				var dc_num = id.replace('comment_Edit_', '');  
				var origin = $('#origin_com').text();
				let html ='<form method="get" action="/Education/Diary/dairy_commentupdate.do">'
					html += '<textarea class="form-control" name="dc_content" rows="4" cols="50">'+origin+'</textarea>';
					html += '<input type="hidden" name="dc_num" value='+dc_num+'>';
					html += '<input type="submit" value="등록"></form>';
				$("#update_form").html(html); 
			});
		
		});
	</script>

</head>
<body>

	<!-- 일지 본문, 댓글 -->
	<article class="resume-wrapper text-center position-relative">
		<div class="resume-wrapper-inner mx-auto text-left bg-white shadow-lg">
			<div class="resume-body p-5">
				<!-- 뒤로가기 -->
				<a href="/Education/Diary/diary_list.do?s_no=${article.s_no}&d_yy=${article.d_yy}&d_mm=${article.d_mm}">뒤로</a>
				
				<!-- 제목 -->
				<div class="d-flex flex-column text-center">
					<h1 class="font-weight-bold" >${article.d_subject}</h1>
				</div>
					<div class="resume-company-name ml-auto text-right">				
						<c:if test="${fn:contains(sessionScope.id,'teacher')}">
						<a href="/Education/Diary/dairy_update.do?d_num=${d_num}">수정</a>&nbsp
						<a href="/Education/Diary/dairy_delete.do?d_num=${d_num}">삭제</a>
						</c:if>
					</div>
				<hr>
				
				<!-- 본문 -->
				<div class="dia_content">${article.d_content}</div>
				
				<hr>
				
				<!-- 댓글 -->
				<div class="dia_comment">
				
					<!-- 댓글 등록 -->
			  		<div class="card my-4">
			        	<h5 class="card-header">댓글</h5>
			          	<div class="card-body">
			            	<form style="display: inline" action="/Education/Diary/dairy_commentwrite.do" method="get">
			                	<div class="form-group">
			                		<textarea class="form-control" id="dc_content" name="dc_content" rows="3" placeholder="의견을 남겨주세요." required></textarea>
			                	</div>
			              		<input type="submit" value="등록" class="btn btn-primary" id="dc_write_button">
			           		</form>
			          	</div>
			        </div>
					
					
					<!-- 댓글 목록 -->
					<div class="dia_show">
						<table border="1" cellpadding="0" cellspacing="0" width="500" height="#">
							<c:choose>
								<c:when test="${empty commentList}">
									<tr>
										<td>댓글쓴이</td>
										<td>댓글이 아직 없습니다.</td>
									</tr>
								</c:when>
				
								<c:otherwise>
									<c:forEach var="comment" items="${commentList}">
										<tr>
											<td>
												<c:if test="${fn:contains(comment.commenter,'teacher')}"> 담당선생님</c:if>
												<c:if test="${fn:indexOf(comment.commenter,'teacher') == -1}"> 학부모님</c:if>
											</td>
											<td colspan="2">
												<div id="update_form"><span id="origin_com">${comment.dc_content}</span><br>
												<small>(${comment.dc_reg_date}) 
												
												<c:if test="${sessionScope.id == comment.commenter}">
													<a href="#" id="comment_Edit_${comment.dc_num}" class="comment_Edit">수정</a>
													<a href="/Education/Diary/dairy_commentdelete.do?dc_num=${comment.dc_num}" onclick="return del()">삭제</a>
												</c:if>
												</small>
												</div>
											</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>					
					</div><!-- dia_show -->
				</div><!-- dia_comment -->
				
				
		 	</div><!-- resume-body -->
		</div><!-- resume-wrapper-inner -->
	</article>
	
</body>
</html>