package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class LoginProAction implements CommandAction {//회원인증 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        String user_id = request.getParameter("user_id");
	    String user_pw  = request.getParameter("user_pw");

        LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
        int check=dbPro.userCheck(user_id, user_pw);

        //해당 뷰에서 사용할 속성
        request.setAttribute("check", new Integer(check));
        request.setAttribute("user_id", user_id);


        return "/K/loginPro.jsp";//해당 뷰
    }
}

