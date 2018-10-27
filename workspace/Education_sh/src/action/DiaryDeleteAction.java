package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.DiaryDBBean;

public class DiaryDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("==================================================");
		System.out.println("[다이어리삭제Action]실행");
		
		int d_num = Integer.parseInt(request.getParameter("d_num"));
		
		DiaryDBBean dbPro = DiaryDBBean.getInstance();
		int s_no = dbPro.getArticle(d_num).getS_no();
		dbPro.deleteArticle(d_num);
		
		request.setAttribute("s_no", s_no);
		
		return "/Sunghee/Diary/diary_Pro.jsp";
	}

}
