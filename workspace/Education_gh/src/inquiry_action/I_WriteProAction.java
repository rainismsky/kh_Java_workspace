package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_WriteProAction implements CommandAction {// �Էµ� �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
       
        InQuiryDataBean article = new InQuiryDataBean();//������ó�� ��
        
        article.setI_subject(request.getParameter("i_subject"));
        System.out.println("1");
        
        article.setI_content(request.getParameter("i_content"));
        System.out.println("2");
        
        System.out.println(article.getI_subject());
        System.out.println(article.getI_content());

        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();//DBó��
        dbPro.insertArticle(article);

        
        
        return "/geunho/inquiry/i_writePro.jsp";
    }
}