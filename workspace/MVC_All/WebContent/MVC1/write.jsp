<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>�Խ���-�Խñ� �Է���</title>
</head>
<body>
<form action="/Education/geunho/MVC1/index.jsp" method="post" onsubmit="return formCheck();">
���� : <input type="text" name="title"/></br>
�ۼ��� : <input type="text" name="writer"/></br>
��¥ : <input type="text" name="regdate"/></br>

���� : <textarea rows="50" cols="50" style="margin: 0px; height:228px; width:436px;"></textarea></br>
<input type="submit"/>

</form>

<script>

function formCheck() {
    var title = document.forms[0].title.value;     
     // ����ϱ� ������ ������ �����Ͽ� ����ְ�,
    var writer = document.forms[0].writer.value;
    var regdate = document.forms[0].regdate.value;
    var content = document.forms[0].content.value; // �߰��Ǿ����ϴ�. �۳���
     
    if (title == null || title == ""){      // null���� ���� ��
        alert('������ �Է��ϼ���');           // ���â�� ����
        document.forms[0].title.focus();    // �ش��±׿� ��Ŀ���� �ص�
        return false;                       // false�� �����մϴ�.
    }
    if (writer == null ||  writer  == ""){   
        alert('�ۼ��ڸ� �Է��ϼ���'); 
        document.forms[0].writer.focus();            
        return false;               
    }
     
    // ���ۼ����� ������ �߰��Ͽ����ϴ�. �Խ��ǿ� �۳����� �翬�� �־�ߵ�
    // �߰��� html�ڵ� : content : <textarea rows="10" cols="20" name="content"></textarea><br>
     
    if (content == null ||  content == ""){
        alert('������ �Է��ϼ���'); 
        document.forms[0].content.focus();
        return false;
    }
     
    if (regdate == null || regdate == ""){
        alert('��¥�� �Է��ϼ���');   
        document.forms[0].regdate.focus();
        return false;
    
    }else if(regdate.match(/[0-9]{4}-[0-9]{2}-[0-9]{2}/) == null){
    	alert("2000��/01��/01�� �������� ����ϼ���");
    	document.forms[0].regdate.focus();
    	return false;
    }
}//function end
</script>

</body>
</html>