package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.BoardDataBean;
import logon.BoardDBBean;
import logon.B_commentDataBean;

public class FbContentAction implements CommandAction {//글내용 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
    	request.setCharacterEncoding("utf-8");
    	HttpSession session = request.getSession();
    	String user_id = (String)session.getAttribute("memId");
    	
    	
    	int b_no = Integer.parseInt(request.getParameter("b_no"));//해당 글번호
        String pageNum = request.getParameter("pageNum");//해당 페이지 번호

        BoardDBBean dbPro = BoardDBBean.getInstance();//DB처리
        BoardDataBean article =  dbPro.getArticle(b_no);//해당 글번호에 대한 해당 레코드

        /*B_commentDataBean bcd = dbPro.insertBcomment(b_no);*/
        
        //해당 뷰에서 사용할 속성
        request.setAttribute("user_id", user_id);
        request.setAttribute("b_no", new Integer(b_no));
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);
       
        System.out.println("컨텐트에서");
        System.out.println(user_id);
        return "/K/fbcontent.jsp";//해당 뷰
    }
}

