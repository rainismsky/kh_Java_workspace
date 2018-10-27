package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class MainAction implements CommandAction {//입력된 글 처리

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/K/main.jsp"; //해당 뷰
	}
}
