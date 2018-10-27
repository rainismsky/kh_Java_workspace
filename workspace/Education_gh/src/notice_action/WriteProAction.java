package notice_action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class WriteProAction implements CommandAction {// �Էµ� �� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
       
        NoticeDataBean article = new NoticeDataBean();//������ó�� ��
        
        article.setN_subject(request.getParameter("n_subject"));
        System.out.println("1");
        
        article.setN_content(request.getParameter("n_content"));
        System.out.println("2");
        
        article.setN_readcount(0);
        System.out.println("3");
        
        article.setN_reg_date(new Timestamp(System.currentTimeMillis()));
        System.out.println("4");
        
        System.out.println(article.getN_subject());
        System.out.println(article.getN_content());
        System.out.println(article.getN_readcount());
        System.out.println(article.getN_reg_date());

        NoticeDBBean dbPro = NoticeDBBean.getInstance();//DBó��
        dbPro.insertArticle(article);

        
        
        return "/geunho/notice/writePro.jsp";
    }
}