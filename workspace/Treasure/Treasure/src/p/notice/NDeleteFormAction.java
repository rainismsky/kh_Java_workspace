
package p.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class NDeleteFormAction implements CommandAction {//글삭제 폼

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int n_no = 0;
        n_no = Integer.parseInt(request.getParameter("n_no"));
        String pageNum = request.getParameter("pageNum");

	//해당 뷰에서 사용할 속성
        request.setAttribute("n_no", new Integer(n_no));
        request.setAttribute("pageNum", new Integer(pageNum));

        return "/P_notice/n_deleteForm.jsp";//해당뷰
    }
}
