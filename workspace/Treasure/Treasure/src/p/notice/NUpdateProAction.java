package p.notice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class NUpdateProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		System.out.println("start");
        String pageNum = request.getParameter("pageNum");

        NoticeDataBean article = new NoticeDataBean();
        article.setN_no(Integer.parseInt(request.getParameter("n_no")));
        article.setN_title(request.getParameter("n_title"));
        //article.setN_date(request.getParameter("n_date"));
        //article.setN_view(Integer.parseInt(request.getParameter("n_view")));
        article.setN_content(request.getParameter("n_content"));
   
        NoticeDBBean dbPro = NoticeDBBean.getInstance();
        int check = dbPro.updateArticle(article);

        request.setAttribute("pageNum", new Integer(pageNum));
        //request.setAttribute("check", new Integer(check));
        System.out.println("end");
        return "/P_notice/n_updatePro.jsp";
	}

}
