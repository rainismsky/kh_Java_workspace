package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_UpdateFormAction implements CommandAction { //�ۼ��� ��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int I_num = Integer.parseInt(request.getParameter("i_num"));
        String pageNum = request.getParameter("pageNum");

        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();
        InQuiryDataBean article = dbPro.updateGetArticle(I_num);

	//�ش� �信�� ����� �Ӽ�
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);

        return "/geunho/inquiry/i_updateForm.jsp"; //�ش��
    }
}