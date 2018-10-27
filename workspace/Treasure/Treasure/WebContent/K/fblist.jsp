<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<link href="../css/menu.css" rel="stylesheet" type="text/css">
<link href="../css/head.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='../css/box.css' type='text/css' />
<title></title>

</head>
<body>
<c:if test="${sessionScope.memId eq 'admin'}">
		<tiles:insertDefinition name="header_admin"/> 
	</c:if>
	<c:if test="${sessionScope.memId ne 'admin'}">
		<tiles:insertDefinition name="header"/> 
	</c:if>
<tiles:insertDefinition name="menu_comu" />

<style>
		#container {
			width: 900px;
						/* 가로로 중앙에 배치 */
			padding-top: 10%;		/* 테두리와 내용 사이의 패딩 여백 */
		}
		
		#list {
			text-align: center;
		}
	
		#write {
			text-align: right;
		}
		
		/* Bootstrap 수정 */
		.table > thead {
			background-color: #b3c6ff;
		}
		.table > thead > tr > th {
			text-align: center;
		}
		.table-hover > tbody > tr:hover {
			background-color: #e6ecff;
		}
		.table > tbody > tr > td {
			text-align: center;
		}
		.table > tbody > tr > #title {
			text-align: left;
		}
		
		div > #paging {
			text-align: center;
		}
		
		.hit {
			animation-name: blink;
			animation-duration: 1.5s;
			animation-timing-function: ease;
			animation-iteration-count: infinite;
			/* 위 속성들을 한 줄로 표기하기 */
			/* -webkit-animation: blink 1.5s ease infinite; */
		}
		
		/* 애니메이션 지점 설정하기 */
		/* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
		@keyframes blink {
			from {color: white;}
			30% {color: yellow;}
			to {color: red; font-weight: bold;}
			/* 0% {color:white;}
			30% {color: yellow;}
			100% {color:red; font-weight: bold;} */
		}
	</style>

<div class="right2" style="display: inline; float: left; position: absolute; margin-left: 0px; left: 31%; top: 50px;">

	<div id="container">
		<div align="right">
			<!-- Login 검증 -->
			<!-- jstl의 if문은 else가 없어서 따로 검증해야함. -->
			
		</div>
	
		<div id="list">
			<b>게시판 (전체 글: ${count})</b>
		</div>
		
		<div id="write">
		
		<form name="writeForm" action="/Treasure/K/fbwriteForm.do" method="post">
<INPUT type="hidden" name="user_id" value="${sessionScope.memId}">
<button type="submit" class="btn btn-success btn-md">글쓰기</button></form>
    </div>
    
    
    
    
    
    
    
<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}">

<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="5%">번호</th>
						<th width="15%">제목</th>
						<th width="10%">작성자</th>
						<th width="15%">작성일</th>
						<th width="5%">조회</th>
					</tr>
				</thead>
<tbody>
   <c:forEach var="article" items="${articleList}"> <!--items 컬렉션을 받아와서 0번부터 ~-->
   <tr>
    <td>
  	<c:out value="${number}"/> <!--리퀘스트 저장되있는 속성값 어트리뷰트 //돌면서 변수로 변함-->
  	<c:set var="number" value="${number - 1}"/>
    </td>
    <td  width="250" >
        <a href="/Treasure/K/fbcontent.do?b_no=${article.b_no}&pageNum=${currentPage}">
          <p class="text-left">${article.b_head}  ${article.b_title}</p>
	</a>
        <c:if test="${article.b_view >= 20}">
        	<img src="images/hot.gif" border="0"  height="16">
 	</c:if>
</td>
    <td align="center"  width="100">
       <a href="#">${article.user_id}</a>
</td>
    <td align="center"  width="150">${article.b_date}
</td>
    <td align="center"  width="50">${article.b_view}</td>
  </tr>
  </c:forEach>
</table>
</c:if>

<c:if test="${count > 0}"><center>
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Treasure/K/fblist.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Treasure/K/fblist.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Treasure/K/fblist.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
</center></c:if>
<form><br><br><center>
<select name="searchn" style="width:70px; height:25px;">
<option value="0">작성자</option>
<option value="1">제목</option>
<option value="2">내용</option>
</select>

<input type="text" name="search" size="15" maxlength="50" style="width:150px; height:25px;"/> 
<button type="submit" class="btn btn-muted btn-sm" />검색</button>
</center></form>
<br></br>

</div>
</div>
</body>
</html>