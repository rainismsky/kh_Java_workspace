package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class LogonDeleteProAction implements CommandAction {//ȸ��Ż�� ó��

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
	    
        LogonDBBean dbPro = LogonDBBean.getInstance();
        int check = dbPro.deleteMember(user_id, user_pw);

        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("check", new Integer(check));

        return "/K/deletePro.jsp";//�ش��
    }
}

