package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_UpdateProAction implements CommandAction {

    public String requestPro( HttpServletRequest request, HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        String pageNum = request.getParameter("pageNum");

	InQuiryDataBean article = new InQuiryDataBean();
        article.setI_num(Integer.parseInt(request.getParameter("i_num")));
        article.setI_subject(request.getParameter("i_subject"));
        article.setI_content(request.getParameter("i_content"));
      
	InQuiryDBBean dbPro = InQuiryDBBean.getInstance();
        int check = dbPro.updateArticle(article);

        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));

        return "/geunho/inquiry/i_updatePro.jsp";
    }	
}