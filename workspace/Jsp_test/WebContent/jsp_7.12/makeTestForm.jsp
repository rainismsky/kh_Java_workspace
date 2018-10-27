<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<html>
<head>

<title>폼 생성</title>
</head>

<body>
폼에 데이터를 입력후 "전송" 버튼 클릭!
<form action="viewParameter.jsp" method="get">
이름 : <input type="text" name="name" size="10"> <br>
주소 : <input type="text" name="address" size="30"> <br>
좋아하는 동물:
	 <input type="checkbox" name="pet" size="dog"> <br>강아지
	 <input type="checkbox" name="pet" size="cat"> <br>고양이
	 <input type="checkbox" name="pet" size="pig"> <br>돼지
<br>
<input type="submit" value="전송">
</form>
</body>
</html>