package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.BoardDBBean;

public class FbDeleteProAction implements CommandAction {//�ۻ���

    public String requestPro( HttpServletRequest request,HttpServletResponse response) throws Throwable {

        request.setCharacterEncoding("utf-8");

        int b_no = Integer.parseInt(request.getParameter("b_no"));
        String pageNum = request.getParameter("pageNum");
        String user_id = request.getParameter("user_id");
   
        BoardDBBean dbPro = BoardDBBean.getInstance();
        int check = dbPro.deleteArticle(b_no);
System.out.println("�������� �޴� ���̵�");
        System.out.println(user_id);
        //�ش� �信�� ����� �Ӽ�
        
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("check", new Integer(check));

        return "/K/fbboarddeletePro.jsp";//�ش��
    }
}
