package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class IdSearchProAction implements CommandAction {//회원인증 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String user_name = request.getParameter("user_name");
	    String user_birth  = request.getParameter("user_birth");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
        String user_id = dbPro.findId(user_name, user_birth);
        
        request.setAttribute("user_id", user_id);
        request.setAttribute("user_name", user_name);

        return "/K/IdSearchPro.jsp";//해당 뷰
    }
}
