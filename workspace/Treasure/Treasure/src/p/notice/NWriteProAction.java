package p.notice;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class NWriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		NoticeDataBean article = new NoticeDataBean();
		//article.setN_no(Integer.parseInt(request.getParameter("n_no")));
		article.setN_title(request.getParameter("n_title"));
		//article.setN_view(Integer.parseInt(request.getParameter("n_view")));
		article.setN_date(new Timestamp(System.currentTimeMillis()));
		article.setN_content(request.getParameter("n_content"));
		System.out.println("request.getParameter(\"n_title\")" + request.getParameter("n_title"));
		
		NoticeDBBean ndbPro = NoticeDBBean.getInstance();
		ndbPro.insertArticle(article);
		
		return "/P_notice/n_writePro.jsp";
	}

}
