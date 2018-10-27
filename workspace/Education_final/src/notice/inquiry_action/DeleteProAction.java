package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;

public class DeleteProAction implements CommandAction {//�ۻ���

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        int N_num = Integer.parseInt(request.getParameter("n_num"));
        String pageNum = request.getParameter("pageNum");
        String passwd = request.getParameter("passwd");
   
        NoticeDBBean dbPro = NoticeDBBean.getInstance();
        int check = dbPro.deleteArticle(N_num, passwd);

        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));

        return "/geunho/notice/deletePro.jsp";//�ش��
    }
}