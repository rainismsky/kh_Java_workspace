package s.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import s.bean.AdminDBBean;

public class AdminGradeUpDownAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId");	
		String user_id = request.getParameter("user_id"); 
		String grade = request.getParameter("grade"); 
		String blackListReason = request.getParameter("blackListReason"); 
		AdminDBBean amdb = AdminDBBean.getInstance();
		System.out.println(grade);
		if(grade.equals("BlackList")) {
		amdb.registBlackList(user_id, grade, blackListReason);
		
		} else {
			amdb.gradeUpDown(user_id, grade);
		}
		
		return "/S/selfClose.jsp";
	}

}
