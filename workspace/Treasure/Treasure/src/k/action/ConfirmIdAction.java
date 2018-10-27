package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class ConfirmIdAction implements CommandAction {//입력된 글 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//한글 인코딩
		
		String user_id = request.getParameter("user_id");//사용자입력 아이디
		
		LogonDBBean dbPro = LogonDBBean.getInstance();//DB처리
		int check = dbPro.confirmId(user_id);
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("user_id", user_id);
		request.setAttribute("check", new Integer(check));
		
		return "/K/confirmId.jsp"; //해당 뷰
	}
}
