<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import = "board.BoardDBBean" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="article" scope="page" class="board.BoardDataBean">
   <jsp:setProperty name="article" property="*"/> <!--같은 이름으로 전달된 파라미터로 객체 전달을할꺼다 property-->
</jsp:useBean>

<%
    article.setReg_date(new Timestamp(System.currentTimeMillis()) );
article.setIp(request.getRemoteAddr());

    BoardDBBean dbPro = BoardDBBean.getInstance();
    dbPro.insertArticle(article);

    response.sendRedirect("list.jsp");
%>