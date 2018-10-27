<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="color.jsp"%>
<html>
<head>
<title>비밀번호 변경</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
   
    function checkIt() {
        var userinput = eval("document.userinput");
        
      
        if(!userinput.passwd.value ) {
            alert("비밀번호를 입력하세요");
            return false;
        }
        if(userinput.passwd.value != userinput.passwd2.value)
        {
            alert("비밀번호를 동일하게 입력하세요");
            return false;
        }

        return true;
    }

   
</script>


<body bgcolor="<%=bodyback_c%>">

<form method="post" action="updatePwdPro.jsp" name="userinput"  onSubmit="return checkIt()">
  <table border="1" cellspacing="0" cellpadding="3" align="center" >
    <tr>
    <td colspan="2" height="39" align="center" bgcolor="<%=value_c%>" >
       <font size="+1" ><b>비밀번호 변경</b></font></td>
    </tr>

    <tr>
      <td> 비밀번호</td>
      <td>
        <input type="password" name="passwd" size="15" maxlength="12">
      </td>
    <tr> 
      <td>비밀번호 확인</td>
      <td>
        <input type="password" name="passwd2" size="15" maxlength="12">
      	<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
      </td>
    </tr>
    <tr>
      <td colspan="2" align="right" bgcolor="<%=value_c%>">
          <input type="submit" name="confirm" value="변경" >
      </td>
    </tr>
  </table>
</form>
</body>
</html>