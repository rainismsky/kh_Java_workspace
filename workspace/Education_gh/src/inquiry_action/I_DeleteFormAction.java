package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_action.CommandAction;

public class I_DeleteFormAction implements CommandAction {//�ۻ��� ��

    public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        int I_num = Integer.parseInt(request.getParameter("i_num"));
        String pageNum = request.getParameter("pageNum");

	//�ش� �信�� ����� �Ӽ�
	request.setAttribute("i_num", new Integer(I_num));
        request.setAttribute("pageNum", new Integer(pageNum));

        return "/geunho/inquiry/i_deleteForm.jsp";//�ش��
    }
}