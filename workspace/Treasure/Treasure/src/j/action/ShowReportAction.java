package j.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.show.ShowDBBean;

public class ShowReportAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		String user_id = request.getParameter("user_id");
		
		ShowDBBean sdbb = ShowDBBean.getInstance();
		int check = sdbb.reportShow(show_no, sessionId);
		
		request.setAttribute("check", new Integer(check));
		request.setAttribute("show_no", show_no);
		request.setAttribute("user_id", user_id);
		
		return "/J/showreportPro.jsp";
		
	}

}
