package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.BoardDataBean;
import logon.BoardDBBean;

public class FbUpdateFormAction implements CommandAction {//글수정 폼

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
    	
        int b_no = Integer.parseInt(request.getParameter("b_no"));
        String pageNum = request.getParameter("pageNum");
        
        BoardDBBean dbPro = BoardDBBean.getInstance();
        BoardDataBean article =  dbPro.updateGetArticle(b_no);

	//해당 뷰에서 사용할 속성
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);
        
        return "/K/fbupdateForm.jsp";//해당뷰
    }
}