package notice_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.NoticeDBBean;
import notice.NoticeDataBean;


public class ContentAction implements CommandAction {//�۳��� ó��
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
        int N_num = Integer.parseInt(request.getParameter("n_num"));//�ش� �۹�ȣ *DB primary key
        
     /*   String N_subject = request.getParameter("n_subject");//�ش� �� ����
        String N_content = request.getParameter("n_content");//�ش� �� ����
        String pageNum = request.getParameter("pageNum");//�ش� ������ ��ȣ
*/        
        System.out.println("�̰�:::::"+Integer.parseInt(request.getParameter("n_num")));
        System.out.println(request.getParameter("n_subject"));
        System.out.println(request.getParameter("n_content"));
        System.out.println(request.getParameter("pageNum"));
        
        NoticeDBBean dbPro = NoticeDBBean.getInstance();//DBó��
        NoticeDataBean article =  dbPro.updateGetArticle(N_num);//�ش� �۹�ȣ�� ���� �ش� ���ڵ�
    
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("n_num", new Integer(N_num));//�޾ƿ� �ش� �� ��ȣ *DB primary key

        return "/geunho/notice/content.jsp";//�ش� ��
   
}
}

