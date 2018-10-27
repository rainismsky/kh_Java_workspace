package notice.inquiry_action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class UpdateProAction implements CommandAction {

    public String requestPro( HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        String pageNum = request.getParameter("pageNum");

	NoticeDataBean article = new NoticeDataBean();
        article.setN_num(Integer.parseInt(request.getParameter("n_num")));
        article.setN_subject(request.getParameter("n_subject"));
        article.setN_content(request.getParameter("n_content"));
        article.setN_readcount(Integer.parseInt(request.getParameter("n_readcount")));
        article.setN_reg_date(new Timestamp(System.currentTimeMillis())); //현재 시간을 가져오는 것
      
	NoticeDBBean dbPro = NoticeDBBean.getInstance();
        int check = dbPro.updateArticle(article);

        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));

        return "/geunho/notice/updatePro.jsp";
    }	
}