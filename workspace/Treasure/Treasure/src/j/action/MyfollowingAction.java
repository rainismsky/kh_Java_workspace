package j.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;

public class MyfollowingAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		
		List followingList = sdbb.getFollowingShow(sessionId);
		
		request.setAttribute("followingList", followingList);
		request.setAttribute("sessionId", sessionId);
		
		return "/J/my_following.jsp";
	}

}
