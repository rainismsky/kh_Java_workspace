package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class PasswdSearchProAction implements CommandAction {//ȸ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String user_id = request.getParameter("user_id");
	    String user_pw_hint = request.getParameter("user_pw_hint");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DBó��
        String user_pw = dbPro.findPwd(user_id, user_pw_hint);
        
        request.setAttribute("user_id", user_id);
        request.setAttribute("user_pw", user_pw);

        return "/K/PasswdSearchPro.jsp";//�ش� ��
    }
}