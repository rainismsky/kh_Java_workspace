package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class PasswdSearchProAction implements CommandAction {//회원인증 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String user_id = request.getParameter("user_id");
	    String user_pw_hint = request.getParameter("user_pw_hint");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
        String user_pw = dbPro.findPwd(user_id, user_pw_hint);
        
        request.setAttribute("user_id", user_id);
        request.setAttribute("user_pw", user_pw);

        return "/K/PasswdSearchPro.jsp";//해당 뷰
    }
}