
package p.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class NDeleteFormAction implements CommandAction {//�ۻ��� ��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int n_no = 0;
        n_no = Integer.parseInt(request.getParameter("n_no"));
        String pageNum = request.getParameter("pageNum");

	//�ش� �信�� ����� �Ӽ�
        request.setAttribute("n_no", new Integer(n_no));
        request.setAttribute("pageNum", new Integer(pageNum));

        return "/P_notice/n_deleteForm.jsp";//�ش��
    }
}
