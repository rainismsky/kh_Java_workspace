package j.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import j.lcomment.LcommentDBBean;
import j.lcomment.LcommentDataBean;
import j.show.ShowDBBean;
import j.show.ShowDataBean;

public class LcommentProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");	//한글 인코딩
		int show_no = Integer.parseInt(request.getParameter("show_no"));
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("memId");
		String user_id = request.getParameter("user_id");
		
		LcommentDataBean lcomm = new LcommentDataBean();
		lcomm.setL_comm_content(request.getParameter("content"));
		lcomm.setL_comm_date(new Timestamp(System.currentTimeMillis()));
		lcomm.setUser_id(sessionId);
		
		LcommentDBBean ldbb = LcommentDBBean.getInstance();
		ldbb.insertLcomment(lcomm, show_no);
		
		
		request.setAttribute("show_no", show_no);
		request.setAttribute("user_id", user_id);
		
		return "/J/lcommentPro.jsp";
	}

}
