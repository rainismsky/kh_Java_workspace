package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDBBean;
import board.BoardDataBean;

public class ContentAction implements CommandAction {//�۳��� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       
        int num = Integer.parseInt(request.getParameter("num"));//�ش� �۹�ȣ
        String pageNum = request.getParameter("pageNum");//�ش� ������ ��ȣ

        BoardDBBean dbPro = BoardDBBean.getInstance();//DBó��
        BoardDataBean article =  dbPro.getArticle(num);//�ش� �۹�ȣ�� ���� �ش� ���ڵ�
 
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("nu", new Integer(num));
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);
       
        return "/MVC/content.jsp";//�ش� ��
    }
}