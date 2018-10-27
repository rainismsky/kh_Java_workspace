package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.DiaryDBBean;

public class DiaryWriteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("==================================================");
		System.out.println("[���̾���Action]����");
		
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		
		DiaryDBBean dbPro = DiaryDBBean.getInstance();
		List dateList  = dbPro.getDate(s_no);
		
		request.setAttribute("s_no", s_no);
		request.setAttribute("dateList", dateList);
		
		return "/Sunghee/Diary/diary_write.jsp";
	}

}
