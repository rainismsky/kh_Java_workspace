package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class LogonMainAction implements CommandAction {//ȸ���������� ������
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response)throws Throwable {
		
		return "/K/loginmain.jsp";//�ش� ��
	}
}
