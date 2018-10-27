package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.ManageDBBean;
import manage.ManageDataBean;
import manage.TeacherProfileDataBean;

public class ModifyTeacherProfileAction implements CommandAction {
public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		String teacherid = request.getParameter("t_id");
		System.out.println("선생님아이디 : "+teacherid);		
				
		ManageDBBean dbPro = ManageDBBean.getInstance();//DB연동
		TeacherProfileDataBean teacherList = dbPro.getTeacherProfileList(teacherid);
		
        request.setAttribute("t_id", teacherList.getT_id());
        request.setAttribute("t_intro", teacherList.getT_intro());
        request.setAttribute("t_career", teacherList.getT_career());
        request.setAttribute("t_img", teacherList.getT_img());
        
        //수정하기!
		String t_id = request.getParameter("t_id");
		String t_intro = request.getParameter("t_intro");
		String t_career = request.getParameter("t_career");
		String t_img = request.getParameter("t_img");
		

		String update = request.getParameter("update");
		if (update != null) {
			dbPro.updateTeacherProfile(t_id, t_intro, t_career, t_img);
			System.out.println("프로필 수정 ok");
		} 
		
        
		return "/administer/ModifyTeacherProfile.jsp";
	}
}
