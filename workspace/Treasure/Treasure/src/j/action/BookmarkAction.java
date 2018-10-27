package j.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;

public class BookmarkAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		String user_id = request.getParameter("user_id");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		int check = sdbb.checkBookmark(show_no, sessionId);
		
		if(check==1) {
			sdbb.deletebookmarkShow(show_no, sessionId);
			request.setAttribute("bookmarkbox", "../images/diabox.png");
		} else {
			sdbb.bookmarkShow(show_no, sessionId);
			request.setAttribute("bookmarkbox", "../images/paintedDiaBox.png");
		}
		
		request.setAttribute("show_no", show_no);
		request.setAttribute("user_id", user_id);
		
		return "/J/bookmarkPro.jsp";
		
	}

}
