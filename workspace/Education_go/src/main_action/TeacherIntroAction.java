package main_action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.MainDBBean;
import main.MainDataBean;

public class TeacherIntroAction implements action.CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8"); 
		String t_id = request.getParameter("t_id");
				 
		MainDBBean dbPro = MainDBBean.getInstance();//DB연동
		
		//선생님 이름 가져오기
		MainDataBean name = dbPro.getTeacherProfile_name(t_id);
		
		request.setAttribute("t_name", name.getT_name());
		

		
		//선생님 프로필 조회
		ArrayList<MainDataBean> totalList = dbPro.getTeacherProfile(t_id); 
	     		
        /*request.setAttribute("t_intro", totalList.getT_intro());
        request.setAttribute("t_name", totalList.getT_name());
        request.setAttribute("t_tel", totalList.getT_tel());
        request.setAttribute("t_id", totalList.getT_id());
        request.setAttribute("t_career", totalList.getT_career());
        request.setAttribute("t_img", totalList.getT_img());*/
        //request.setAttribute("t_intro", totalList.getT_intro());
        
        request.setAttribute("list1", totalList);
	     
	     
		return "/main/TeacherProfile.jsp";
	}
}
