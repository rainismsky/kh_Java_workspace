package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class LoginFormAction implements CommandAction {//ȸ������ �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
     
        return "/K/loginform.jsp";//�ش� ��
    }
}
