<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>보육의 정석 게시판</title>
<h1>보육의 정석</h1>

<!-- <link href="style.css" rel="stylesheet" type="text/css"> -->
</head>

<center><b>글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right">
       <a href="/Education/geunho/notice/writeForm.do">새글 추가</a>
    </td>
  </tr>
</table>

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
            <table border="1" width="800" cellpadding="0" cellspacing="0" align="center">
                <tr height="35">
                  <td align="center"  width="50"  >번   호</td>
                  <td align="center"  width="230" >제   목</td>
                  <td align="center"  width="70" >작성자</td>
                  <td align="center"  width="50" >조회수</td>
                  <td align="center"  width="150" >작성일자</td>
                </tr>
            
               <c:forEach var="article" items="${articleList}">
               <tr height="35">
                <td align="center"  width="50" >${number}
                 <c:set var="number" value="${number - 1}"/>
                 </td>
                <td  width="230" >
                    <a href="/Education/geunho/notice/content.do?n_num=${article.n_num}">
                      &nbsp;${article.n_subject}</a>
               </td>
                <td align="center"  width="70">관리자</td>
                <td align="center"  width="70">${article.n_readcount}</td>
                <td align="center"  width="150">${article.n_reg_date}</td>
              </tr>
              
              </c:forEach>
            </table>
            </c:if>
            <br>

   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
   </c:if>
         
   <c:if test="${startPage > 10}">
        <a href="/Education/geunho/notice/Notice_list.do?pageNum=${startPage - 10 }">[이전]</a>
   </c:if>

   <c:forEach var="i" begin="${startPage}" end="${endPage}">
       <a href="/Education/geunho/notice/Notice_list.do?pageNum=${i}">[${i}]</a>
   </c:forEach>

   <c:if test="${endPage < pageCount}">
        <a href="/Education/geunho/notice/Notice_list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
               <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
               <!-- pageCount:11 -->
               <c:set var="pageBlock" value="${10}"/>
               <!-- pageBlock:10 -->
               <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
               <!-- result:0 -->
               <c:set var="startPage" value="${result * 10 + 1}" />
               <!-- startPage:1 -->
               <c:set var="endPage" value="${startPage + pageBlock-1}"/>
               <!-- endPage:10 -->
               <c:if test="${endPage > pageCount}">
                    <c:set var="endPage" value="${pageCount}"/>
                    <!-- endPage:10 -->
                        </c:if>
                     
               <c:if test="${startPage > 10}">
                    <a href="/Education/geunho/notice/Notice_list.do?pageNum=${startPage - 10 }">[이전]</a>
               </c:if>     
                  <c:if test="${endPage < pageCount}">
        <a href="/Education/geunho/notice/Notice_list.do?pageNum=${startPage + 10}">[다음]</a>
   </c:if>
        </table>       
</center>

</body>
</html>