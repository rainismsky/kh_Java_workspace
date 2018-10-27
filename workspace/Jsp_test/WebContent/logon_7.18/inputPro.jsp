<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import = "logon.LogonDBBean" %>
<%@ page import = "java.sql.Timestamp" %>

<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="member" class="logon.LogonDataBean">
    <jsp:setProperty name="member" property="*" />
</jsp:useBean>
if(userinput.idcheck.value== ""){
        	alert("id중복 확인하세요");
        	return false;
        }
        if(userinput.idcheck.value != userinput.id.value){
        	alert("id중복 다시 확인하세요");
        	return false;
        } 



<%
    member.setReg_date(new Timestamp(System.currentTimeMillis()) );
    LogonDBBean manager = LogonDBBean.getInstance();
    manager.insertMember(member);

    response.sendRedirect("loginForm.jsp");
    
%>