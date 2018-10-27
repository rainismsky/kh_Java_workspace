package j.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;

public class MylikebookmarkAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		
		List likeList = sdbb.getLikeShow(sessionId);
		List bookmarkList = sdbb.getBookmarkShow(sessionId);		
		
		request.setAttribute("likeList", likeList);
		request.setAttribute("bookmarkList", bookmarkList);
		
		return "/J/my_likebookmark.jsp";
	}

}
