<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="jstl.Member" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member member = new Member();
	HashMap<String, String> pref = new HashMap<String, String>();
%>
<html>
<body>
<c:set var="member" value="<%= member %>" />
<c:set target="${member}" property="name" value="효구는 못말려" />

<c:set var="pref" value="<%= pref %>" />
<c:set var="favoriateColor" value="#{pref.color}" />

회원 이름: ${member.name},
좋아하는 색: ${favoriateColor}

<br />
<c:set target="${pref}" property="color" value="black pink" />

설정 이후 좋아하는 색: ${favoriateColor}

</body>
</html>