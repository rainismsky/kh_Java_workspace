package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class LogoutAction implements CommandAction {//�α׾ƿ� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {

        return "/K/logout.jsp";//�ش� ��
    }
}

