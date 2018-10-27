<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ����</title>

<h1>���� ����</h1>

<p>������ 1588-5566 ���� 09:00~18:00(������ ����)</p>

<a href="/Education/geunho/inquiry/i_writeForm.do"/></a>
</head>

<body>
	<center>
		<b>�۸��(��ü ��:${count})</b>
		<table width="700">
			<tr>
				<td align="right"><a
					href="/Education/geunho/inquiry/i_writeForm.do">�۾���</a></td>
			</tr>
		</table>

		<c:if test="${count == 0}">
			<table width="700" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">�Խ��ǿ� ����� ���� �����ϴ�.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="800" cellpadding="0" cellspacing="0"
				align="center">
				<tr height="35">
					<td align="center" width="50">�� ȣ</td>
					<td align="center" width="250">�� ��</td>
					<td align="center" width="100">��ȸ��</td>
					<td align="center" width="150">�ۼ�����</td>
				</tr>

				<c:forEach var="article" items="${articleList}">
					<tr height="35">
						<td align="center" width="50">${number}<c:set var="number"
								value="${number - 1}" />
						</td>
						<td width="250"><a
							href="/Education/geunho/inquiry/i_content.do?i_num=${article.i_num}&pageNum=${currentPage}">
								&nbsp;${article.i_subject}</a></td>
						<td align="center" width="100">������</td>
						<td align="center" width="150">${article.n_reg_date}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<br>

		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${10}" />
		<fmt:parseNumber var="result" value="${currentPage / 10}"
			integerOnly="true" />
		<c:set var="startPage" value="${result * 10 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > 10}">
			<a href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${startPage - 10 }">[����]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a
				href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${startPage + 10}">[����]</a>
		</c:if>

		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<!-- pageCount:11 -->
		<c:set var="pageBlock" value="${10}" />
		<!-- pageBlock:10 -->
		<fmt:parseNumber var="result" value="${currentPage / 10}"
			integerOnly="true" />
		<!-- result:0 -->
		<c:set var="startPage" value="${result * 10 + 1}" />
		<!-- startPage:1 -->
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<!-- endPage:10 -->
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
			<!-- endPage:10 -->
		</c:if>

		<c:if test="${startPage > 10}">
			<a
				href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${startPage - 10 }">[����]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a href="/Education/geunho/inquiry/inquiry_list.do?pageNum=${startPage + 10}">[����]</a>
		</c:if>
	</center>
</body>
</html>