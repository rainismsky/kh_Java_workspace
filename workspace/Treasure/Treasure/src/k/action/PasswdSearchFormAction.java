package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class PasswdSearchFormAction implements CommandAction {//ȸ������ �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
     
        return "/K/PasswdSearchForm.jsp";//�ش� ��
    }
}
