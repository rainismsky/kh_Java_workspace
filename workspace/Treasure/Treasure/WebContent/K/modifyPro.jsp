<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<script type="text/javascript">
            alert("회원정보가 수정되었습니다.");
        
</script>
<title>회원정보수정</title>

<c:if test="${sessionScope.memId eq 'admin'}">
<script>
function selfReload() {
	opener.location.reload();
	self.close();
	
}
window.onload=selfReload();
</script>
</c:if>

<c:if test="${sessionScope.memId ne 'admin'}">
<meta http-equiv="Refresh" content="0;url=/Treasure/J/main.do" >
</c:if>

</body>
</html>

