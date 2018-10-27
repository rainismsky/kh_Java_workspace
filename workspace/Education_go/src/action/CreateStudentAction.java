package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;

public class CreateStudentAction implements CommandAction {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		String s_name = request.getParameter("s_name");
		String birth = request.getParameter("s_birth");
		String tel = request.getParameter("s_tel");
		String t_id = request.getParameter("t_id");
		String u_id = request.getParameter("u_id");
		String img = request.getParameter("s_img");
		
		ManageDBBean dbPro = ManageDBBean.getInstance();// DB¿¬µ¿
		dbPro.insert_student(s_name, birth, tel, t_id, u_id, img);


		return "/administer/CreateStudent.jsp";
	}

}
