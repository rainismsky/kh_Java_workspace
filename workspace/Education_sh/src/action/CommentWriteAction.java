package action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diary.Diary_CommentDBBean;
import diary.Diary_CommentDataBean;

public class CommentWriteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("==================================================");
		System.out.println("[코멘트 추가]실행!"+request.getParameter("dc_content"));
		
		Diary_CommentDataBean comment = new Diary_CommentDataBean();
		comment.setD_num(Integer.parseInt(request.getParameter("d_num")));
		comment.setDc_content(request.getParameter("dc_content"));
		comment.setDc_reg_date(new Timestamp(System.currentTimeMillis()));
		comment.setCommenter(request.getSession().getAttribute("id").toString());
		
		HashMap<String, Object> result = Diary_CommentDBBean.getInstance().insertComment(comment);
		request.setAttribute("result",result);

		
		request.setAttribute("d_num",comment.getD_num());
		System.out.println(">>(전달)"+result);
		
		return  "/Sunghee/Diary/comment_Pro.jsp";
	}

}
