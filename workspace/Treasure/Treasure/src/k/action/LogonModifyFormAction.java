package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.LogonDataBean;

public class LogonModifyFormAction implements CommandAction {//회원정보 수정 폼 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        String user_id = request.getParameter("user_id");
    	HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		
        LogonDBBean dbPro = LogonDBBean.getInstance();
        /*if(sessionId.equals("admin")||sessionId.equals("Admin")) {
        	LogonDataBean member =  dbPro.getMember(user_id);
        }*/
        LogonDataBean member =  dbPro.getMember(user_id);
        
		//해당 뷰에서 사용할 속성
        request.setAttribute("member", member);

        return "/K/modifyForm.jsp";//해당뷰
    }
}

