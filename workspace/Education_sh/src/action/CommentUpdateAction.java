package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.Diary_CommentDBBean;
import diary.Diary_CommentDataBean;

public class CommentUpdateAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		System.out.println("==================================================");
		System.out.println("[코멘트 수정]실행!");

		Diary_CommentDataBean comment = new Diary_CommentDataBean();
		comment.setDc_num(Integer.parseInt(request.getParameter("dc_num")));
		comment.setDc_content(request.getParameter("dc_content"));
		comment.setDc_reg_date(new Timestamp(System.currentTimeMillis()));
		
		
		Diary_CommentDBBean dbPro = Diary_CommentDBBean.getInstance();
		dbPro.updateComment(comment);
		int d_num = dbPro.getComment(Integer.parseInt(request.getParameter("dc_num"))).getD_num();

		request.setAttribute("d_num",d_num);
		
		return "/Sunghee/Diary/comment_Pro.jsp";
	}

}
