package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class CreateTeacherAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

	String t_id = request.getParameter("t_id");
	String t_pass = request.getParameter("t_pass");
	String t_name = request.getParameter("t_name");
	String t_tel = request.getParameter("t_tel");
	String t_birth = request.getParameter("t_birth");
	String t_addr = request.getParameter("t_addr");
	String t_zipcode = request.getParameter("t_zipcode");

	ManageDBBean dbPro = ManageDBBean.getInstance();// DB¿¬µ¿
	dbPro.insert_teacher(t_id, t_pass, t_name, t_tel, t_birth, t_addr, t_zipcode);

	return "/administer/CreateTeacher.jsp";
	}
}
