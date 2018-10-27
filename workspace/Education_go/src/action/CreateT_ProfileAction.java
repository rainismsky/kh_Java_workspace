package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class CreateT_ProfileAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
		
		String t_id = request.getParameter("t_id");
		String t_img = request.getParameter("t_img");
		String t_intro = request.getParameter("t_intro");
		String t_career = request.getParameter("t_career");
		
		ManageDBBean dbPro = ManageDBBean.getInstance();// DB¿¬µ¿
		dbPro.insert_teacherProfile(t_id, t_img, t_intro, t_career);
		
		return "/administer/CreateTeacherProfile.jsp";
		}
}
