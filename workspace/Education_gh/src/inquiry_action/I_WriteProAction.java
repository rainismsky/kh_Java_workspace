package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_WriteProAction implements CommandAction {// 涝仿等 臂 贸府

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//茄臂 牢内爹
       
        InQuiryDataBean article = new InQuiryDataBean();//单捞磐贸府 后
        
        article.setI_subject(request.getParameter("i_subject"));
        System.out.println("1");
        
        article.setI_content(request.getParameter("i_content"));
        System.out.println("2");
        
        System.out.println(article.getI_subject());
        System.out.println(article.getI_content());

        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();//DB贸府
        dbPro.insertArticle(article);

        
        
        return "/geunho/inquiry/i_writePro.jsp";
    }
}