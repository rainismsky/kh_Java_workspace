package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {//�ۻ��� ��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int n_num = Integer.parseInt(request.getParameter("n_num"));
        String pageNum = request.getParameter("pageNum");

	//�ش� �信�� ����� �Ӽ�
	request.setAttribute("n_num", new Integer(n_num));
        request.setAttribute("pageNum", new Integer(pageNum));

        return "/geunho/notice/deleteForm.jsp";//�ش��
    }
}