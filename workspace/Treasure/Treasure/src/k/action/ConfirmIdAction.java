package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;

public class ConfirmIdAction implements CommandAction {//�Էµ� �� ó��

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
		
		String user_id = request.getParameter("user_id");//������Է� ���̵�
		
		LogonDBBean dbPro = LogonDBBean.getInstance();//DBó��
		int check = dbPro.confirmId(user_id);
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("user_id", user_id);
		request.setAttribute("check", new Integer(check));
		
		return "/K/confirmId.jsp"; //�ش� ��
	}
}
