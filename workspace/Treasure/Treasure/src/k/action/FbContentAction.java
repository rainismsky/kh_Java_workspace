package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import j.action.CommandAction;
import logon.BoardDataBean;
import logon.BoardDBBean;
import logon.B_commentDataBean;

public class FbContentAction implements CommandAction {//�۳��� ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
    	request.setCharacterEncoding("utf-8");
    	HttpSession session = request.getSession();
    	String user_id = (String)session.getAttribute("memId");
    	
    	
    	int b_no = Integer.parseInt(request.getParameter("b_no"));//�ش� �۹�ȣ
        String pageNum = request.getParameter("pageNum");//�ش� ������ ��ȣ

        BoardDBBean dbPro = BoardDBBean.getInstance();//DBó��
        BoardDataBean article =  dbPro.getArticle(b_no);//�ش� �۹�ȣ�� ���� �ش� ���ڵ�

        /*B_commentDataBean bcd = dbPro.insertBcomment(b_no);*/
        
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("user_id", user_id);
        request.setAttribute("b_no", new Integer(b_no));
        request.setAttribute("pageNum", new Integer(pageNum));
        request.setAttribute("article", article);
       
        System.out.println("����Ʈ����");
        System.out.println(user_id);
        return "/K/fbcontent.jsp";//�ش� ��
    }
}

