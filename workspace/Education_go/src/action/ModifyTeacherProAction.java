package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class ModifyTeacherProAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�

		
		String t_id = request.getParameter("t_id");
		String t_pass = request.getParameter("t_pass");
		String t_name = request.getParameter("t_name");
		String t_tel = request.getParameter("t_tel");
		String t_birth = request.getParameter("t_birth");
		String t_addr = request.getParameter("t_addr");
					
		System.out.println("pro�� ������ ���̵�"+t_id);
		ManageDBBean dbPro = ManageDBBean.getInstance();
		dbPro.updateTeacher(t_id, t_pass, t_name, t_tel, t_birth, t_addr);
		
		return "/administer/ModifyTeacherPro.jsp";
	}
	
	
}
