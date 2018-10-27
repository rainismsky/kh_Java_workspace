
package p.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class NDeleteProAction implements CommandAction {//글삭제

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");
        System.out.println("gggggg");

        int n_no = 0;
        n_no = Integer.parseInt(request.getParameter("n_no"));
        String pageNum = request.getParameter("pageNum");
        System.out.println("n_no22" +  n_no);
        NoticeDBBean dbPro = NoticeDBBean.getInstance();
        dbPro.deleteArticle(n_no);

        //해당 뷰에서 사용할 속성
        request.setAttribute("pageNum", new Integer(pageNum));
       // request.setAttribute("check", new Integer(check));

        return "/P_notice/n_deletePro.jsp";//해당뷰
    }
}
