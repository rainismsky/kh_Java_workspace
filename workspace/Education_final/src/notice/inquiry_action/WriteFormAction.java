package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {//�� �Է� �� ó��
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
       
//�� ��ȣ��  ����,������ ����
     int N_num=1;

     try{ 
     
    	 if(request.getParameter("n_num")!=null){
		 
         N_num=Integer.parseInt(request.getParameter("n_num")); //�۹�ȣ
    
          }
	}catch(Exception e){
		e.printStackTrace();
	}
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("n_num", new Integer(N_num));

		return "/geunho/notice/writeForm.jsp"; //�ش� ��
	}
}