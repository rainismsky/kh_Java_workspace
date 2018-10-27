package j.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;
import j.show.ShowDataBean;

public class LikeAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		String artist = request.getParameter("artist");
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		int check = sdbb.checkIlike(show_no, sessionId);
		System.out.println("check : " + check);
		if(check==1) {
			sdbb.deleteilikeShow(show_no, sessionId);
			request.setAttribute("likedia", "../images/dia.png");
		} else {
			sdbb.ilikeShow(show_no, sessionId, artist);
			request.setAttribute("likedia", "../images/painteddia.png");
		}
		
		request.setAttribute("show_no", show_no);
		request.setAttribute("user_id", artist);
		
		return "/J/likePro.jsp";
	}

}
