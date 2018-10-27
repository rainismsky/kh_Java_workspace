package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {//글삭제 폼

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int n_num = Integer.parseInt(request.getParameter("n_num"));
        String pageNum = request.getParameter("pageNum");

	//해당 뷰에서 사용할 속성
	request.setAttribute("n_num", new Integer(n_num));
        request.setAttribute("pageNum", new Integer(pageNum));

        return "/geunho/notice/deleteForm.jsp";//해당뷰
    }
}