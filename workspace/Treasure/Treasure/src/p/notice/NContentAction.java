package p.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;


public class NContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int n_no = Integer.parseInt(request.getParameter("n_no")); 
		String pageNum = request.getParameter("pageNum");
		HttpSession session=request.getSession();
		String sessionId=(String)session.getAttribute("memId"); 
		
		NoticeDBBean ndbPro = NoticeDBBean.getInstance();
		NoticeDataBean article = ndbPro.getArticle(n_no);
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("n_no", new Integer(n_no));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		request.setAttribute("sessionId", sessionId);
		
		return "/P_notice/n_content.jsp";
	}

}
