package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class DeleteT_ProfileAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		String t_id = request.getParameter("t_id");
		
		//System.out.println("�̰� Teacher����Action�� t_id: "+t_id);
			
		ManageDBBean dbPro = ManageDBBean.getInstance();// DB����
		dbPro.delete_teacherProfile(t_id);
		
		return "/administer/TeacherProfileManagePro.jsp";
		}
}
