package p.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;


public class NUpdateFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		System.out.println(n_no);
        String pageNum = request.getParameter("pageNum");

        NoticeDBBean dbPro = NoticeDBBean.getInstance();
        NoticeDataBean article =  dbPro.updateGetArticle(n_no);

        //해당 뷰에서 사용할 속성
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);

        //System.out.println("zzzzzzzzzzzzzzzzzz");
        return "/P_notice/n_updateForm.jsp";//해당뷰
	}
}
