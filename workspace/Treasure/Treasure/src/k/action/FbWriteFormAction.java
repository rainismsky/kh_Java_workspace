package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class FbWriteFormAction implements CommandAction {//�� �Է� �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       //����۰� �亯���� ����
    	
    	String user_id = request.getParameter("user_id");
        int b_no=0; 
        try{ 
          if(request.getParameter("b_no")!=null){
		 b_no=Integer.parseInt(request.getParameter("b_no"));
	   }
	}catch(Exception e){
		e.printStackTrace();
	}
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("b_no", new Integer(b_no));
		request.setAttribute("user_id", user_id);
		System.out.println("����Ʈ�� �׼�");
		System.out.println(b_no);
		return "/K/fbwriteForm.jsp";//�ش� ��
	}
}