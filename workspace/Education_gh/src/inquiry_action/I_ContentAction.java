package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_ContentAction implements CommandAction {//글내용 처리
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
        int I_num = Integer.parseInt("i_num");//해당 글번호
        
        System.out.println("이건:::::"+Integer.parseInt(request.getParameter("i_num")));
        System.out.println(request.getParameter("i_subject"));
        System.out.println(request.getParameter("i_content"));
        System.out.println(request.getParameter("pageNum"));
        
/*        String N_subject = request.getParameter("n_subject");//해당 글 제목
        String N_content = request.getParameter("n_content");//해당 글 내용
        String pageNum = request.getParameter("pageNum");//해당 페이지 번호
*/        
        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();//DB처리
        InQuiryDataBean article =  dbPro.updateGetArticle(I_num);//해당 글번호에 대한 해당 레코드
        
        //해당 뷰에서 사용할 속성
        request.setAttribute("n_num", new Integer(I_num));//받아올 해당 글 번호
     /*   request.setAttribute("n_subject", new Integer(N_subject)); // 받아올 해당 글 제목
        request.setAttribute("n_content",new Integer(N_content)); // 받아올 해당 글 내용
        request.setAttribute("pageNum", new Integer(pageNum)); // 받아올 해당 페이지 번호
        request.setAttribute("article", article); // 받아올 아티클 객체들?
*/       
        return "/geunho/inquiry/i_content.jsp";//해당 뷰
    
}
}
