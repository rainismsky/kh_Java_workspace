package action;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.DiaryDBBean;
import student.StudentDBBean;
import student.StudentDataBean;
import teacher.TeacherDBBean;
import users.UsersDBBean;
import users.UsersDataBean;

public class DiaryListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("==================================================");
		System.out.println("[다이어리리스트]실행!");
		
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		int d_yy = LocalDate.now().getYear();
		int d_mm = LocalDate.now().getMonthValue();;
		
		if(request.getParameter("d_yy") != null) {
			d_yy = Integer.parseInt(request.getParameter("d_yy"));
			d_mm = Integer.parseInt(request.getParameter("d_mm"));
		}
		
		StudentDataBean student = StudentDBBean.getInstance().getStudent(s_no);
		List articleList = DiaryDBBean.getInstance().getArticles(d_yy,d_mm,s_no);
		int end_day = YearMonth.of(d_yy,d_mm).lengthOfMonth();
		String t_name = TeacherDBBean.getInstance().getName(student.getT_id());
		UsersDataBean user = UsersDBBean.getInstance().getUser(student.getU_id());
		
		request.setAttribute("student",student);		
		request.setAttribute("articleList",articleList);
		request.setAttribute("end_day",end_day);
		request.setAttribute("d_yy", d_yy);
		request.setAttribute("d_mm", d_mm);
		request.setAttribute("t_name", t_name);
		request.setAttribute("user", user);
		
		
		System.out.println(">>(전송)"+articleList+"/끝날:"+end_day+"/"+student);			
		
		return "/Sunghee/Diary/diary_list.jsp";
	}

	
}
