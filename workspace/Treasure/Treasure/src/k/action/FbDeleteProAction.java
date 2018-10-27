package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.BoardDBBean;

public class FbDeleteProAction implements CommandAction {//글삭제

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        int b_no = Integer.parseInt(request.getParameter("b_no"));
        String pageNum = request.getParameter("pageNum");
        String user_id = request.getParameter("user_id");
   
        BoardDBBean dbPro = BoardDBBean.getInstance();
        int check = dbPro.deleteArticle(b_no);
System.out.println("삭제에서 받는 아이디");
        System.out.println(user_id);
        //해당 뷰에서 사용할 속성
        
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));

        return "/K/fbboarddeletePro.jsp";//해당뷰
    }
}
