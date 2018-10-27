package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class IdSearchProAction implements CommandAction {//ȸ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String user_name = request.getParameter("user_name");
	    String user_birth  = request.getParameter("user_birth");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DBó��
        String user_id = dbPro.findId(user_name, user_birth);
        
        request.setAttribute("user_id", user_id);
        request.setAttribute("user_name", user_name);

        return "/K/IdSearchPro.jsp";//�ش� ��
    }
}
