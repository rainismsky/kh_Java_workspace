package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;


public class LogonDeleteFormAction implements CommandAction {//ȸ��Ż�� �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        return "/K/deleteForm.jsp";//�ش��
    }
}

