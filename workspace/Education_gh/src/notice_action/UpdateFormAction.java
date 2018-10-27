package notice_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;

public class UpdateFormAction implements CommandAction { //�ۼ��� ��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int N_num = Integer.parseInt(request.getParameter("n_num"));
        String pageNum = request.getParameter("pageNum");

        NoticeDBBean dbPro = NoticeDBBean.getInstance();
        NoticeDataBean article =  dbPro.updateGetArticle(N_num);

	//�ش� �信�� ����� �Ӽ�
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);

        return "/geunho/notice/updateForm.jsp"; //�ش��
    }
}