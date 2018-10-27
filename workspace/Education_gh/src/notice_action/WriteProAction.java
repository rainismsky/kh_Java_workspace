package notice_action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class WriteProAction implements CommandAction {// 涝仿等 臂 贸府

    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {

        request.setCharacterEncoding("utf-8");//茄臂 牢内爹
       
        NoticeDataBean article = new NoticeDataBean();//单捞磐贸府 后
        
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

        NoticeDBBean dbPro = NoticeDBBean.getInstance();//DB贸府
        dbPro.insertArticle(article);

        
        
        return "/geunho/notice/writePro.jsp";
    }
}