package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class LogonInputFormAction implements CommandAction {//È¸¿ø°¡ÀÔ Æû Ã³¸®
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		
		return "/K/inputForm.jsp";//ÇØ´ç ºä
	}
}
