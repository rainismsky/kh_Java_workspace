package j.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logon.LogonDBBean;

public class FollowAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		String follow = request.getParameter("user_id");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		LogonDBBean ldbb = LogonDBBean.getInstance();
		int check = ldbb.checkfollow(follow, sessionId);
		System.out.println("follow check : " + check);
		
		if(check==1) {
			ldbb.unfollow(follow, sessionId);
			
		} else {
			ldbb.follow(follow, sessionId);
			
		}
		
		request.setAttribute("user_id", follow);
		
		return "/J/followPro.jsp";
		
	}

}
