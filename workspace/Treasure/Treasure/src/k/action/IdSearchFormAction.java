package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class IdSearchFormAction implements CommandAction {//회원인증 폼 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
     
        return "/K/IdSearchForm.jsp";//해당 뷰
    }
}
