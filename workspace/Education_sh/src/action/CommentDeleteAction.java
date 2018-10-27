package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.Diary_CommentDBBean;
import diary.Diary_CommentDataBean;

public class CommentDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("==================================================");
		System.out.println("[코멘트삭제Action]실행");
		
		int dc_num = Integer.parseInt(request.getParameter("dc_num"));
		
		Diary_CommentDBBean dbPro = Diary_CommentDBBean.getInstance();
		int d_num = dbPro.getD_num(dc_num);
				dbPro.deleteComment(dc_num);
		
		request.setAttribute("d_num",d_num);
		
		return "/Sunghee/Diary/comment_Pro.jsp";
	}

}
