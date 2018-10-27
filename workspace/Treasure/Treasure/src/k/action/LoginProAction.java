package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class LoginProAction implements CommandAction {//ȸ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String user_id = request.getParameter("user_id");
	    String user_pw  = request.getParameter("user_pw");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DBó��
        int check=dbPro.userCheck(user_id, user_pw);

        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("check", new Integer(check));
        request.setAttribute("user_id", user_id);


        return "/K/loginPro.jsp";//�ش� ��
    }
}

