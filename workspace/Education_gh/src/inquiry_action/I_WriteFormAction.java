package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_action.CommandAction;

public class I_WriteFormAction implements CommandAction {//�� �Է� �� ó��
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
       
//�� ��ȣ��  ����,������ ����
     int I_num=0;
/*     String N_subject = request.getParameter("n_subject"); 
     String N_content = request.getParameter("n_content");
 */
     try{ 
     
    	 if(request.getParameter("i_num")!=null){
		 
         I_num=Integer.parseInt(request.getParameter("i_num")); //�۹�ȣ
 /*        N_subject=(request.getParameter("n_subject")); //�� ����
		 N_content=(request.getParameter("n_content")); //�� ���� 			 
      */    
          }
	}catch(Exception e){
		e.printStackTrace();
	}
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("i_num", new Integer(I_num));
	/*	request.setAttribute("n_subject", new String(N_subject));
		request.setAttribute("n_content", new String(N_content));
*/
		return "/geunho/inquiry/i_writeForm.jsp"; //�ش� ��
	}
}