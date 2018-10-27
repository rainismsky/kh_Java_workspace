package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class DeleteTeacherAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
		
		String teacherid = request.getParameter("t_id");
		System.out.println("�̰� Teacher����Action�� t_id: "+teacherid);
		
		ManageDBBean dbPro = ManageDBBean.getInstance();
		dbPro.deleteTeacher(teacherid);
		
		return "/administer/UsersManagePro_T.jsp";
	}
}
