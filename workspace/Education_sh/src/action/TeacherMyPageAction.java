package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.StudentDBBean;
import teacher.TeacherDBBean;
import teacher.WeeklyScheduleDBBean;

public class TeacherMyPageAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.println("==================================================");
		System.out.println("[티져페이지액션]실행!");
		
		String t_id = request.getSession().getAttribute("id").toString();
		
		String t_name= TeacherDBBean.getInstance().getName(t_id);
		List studentList = StudentDBBean.getInstance().getStudents(t_id);
		List wsList = WeeklyScheduleDBBean.getInstance().getWeeklySchedules(t_id);
		
		request.setAttribute("studentList",studentList);
		request.setAttribute("t_name",t_name);
		request.setAttribute("wsList",wsList);
		
		System.out.println(">>[jsp전달]"+wsList);
		return "/Sunghee/Teacher/t_mypage.jsp";
	}

}
